package jp.entropia.sirens.controller;

import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.Manager;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.model.EventModel;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.EventService;
import jp.entropia.sirens.service.ManagerService;
import jp.entropia.sirens.service.MemberService;
import jp.entropia.sirens.service.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.transfer.Upload;

@RestController
@RequestMapping(value="/event")
public class EventController {

	@Autowired
	private EventService eventService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private S3Service s3Service;
	@Autowired
	private ActivityService activityService;
	
	private static final String s3Url = "https://s3-ap-northeast-1.amazonaws.com/band.sirens/event/";
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody EventModel model, Principal principal) {
		// TODO DomaのLocalTransaction使う
		Event event = new Event();
		event.setName(model.getName());
		event.setStartTime(model.getStartTime().toLocalDateTime());
		event.setEndTime(model.getEndTime().toLocalDateTime());
		eventService.save(event);
		
		// バンオフ作成者は参加者としても登録
		Member member = new Member();
		member.setEventId(event.getId());
		member.setUserid(principal.getName());
		member.setAttendParty("参加");
		memberService.save(member);
		
		// バンオフ作成者は管理者になる
		Manager manager = new Manager();
		manager.setEventId(event.getId());
		manager.setMemberId(member.getId());
		managerService.save(manager);
		
		activityService.publish("headline.addEvent");
	}
	
	@RequestMapping(value="/{eventId}", method=RequestMethod.PUT)
	public void update(@PathVariable("eventId") Integer eventId, @RequestBody EventModel model, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		eventService.update(eventService.convertObject(model));
		activityService.publish("headline.updateEvent");
	}
	
	@RequestMapping(value="/{eventId}", method=RequestMethod.GET)
	public Event get(@PathVariable("eventId") Integer eventId) {
		Event event = eventService.find(eventId);
		return event;
	}
	
	@RequestMapping(value="/managed", method=RequestMethod.GET)
	public List<EventModel> getEventManagedByLoginUser(Principal principal) {
		return eventService.findManagedEvents(principal.getName())
				.stream()
				.map(e -> eventService.convertObject(e))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/joined", method=RequestMethod.GET)
	public List<EventModel> getEventJoinedByLoginUser(Principal principal) {
		return eventService.findJoinedEvents(principal.getName())
				.stream()
				.map(e -> eventService.convertObject(e))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/past", method=RequestMethod.GET)
	public List<EventModel> getPastEvent() {
		return eventService.findPastEvents()
				.stream()
				.map(e -> eventService.convertObject(e))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/future", method=RequestMethod.GET)
	public List<EventModel> getFutureEvent() {
		return eventService.findFutureEvents()
				.stream()
				.map(e -> eventService.convertObject(e))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/{eventId}/is-manager", method=RequestMethod.GET)
	public void isCurrentUserManager(@PathVariable("eventId") Integer eventId, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
	}
	
	@RequestMapping(value="/{eventId}/image", method=RequestMethod.POST)
	public @ResponseBody UploadFileResponse uploadImage(@PathVariable("eventId") Integer eventId,
			@RequestParam("file") MultipartFile file, Principal principal) {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
            try {
            	File f = File.createTempFile(fileName, null);
            	file.transferTo(f);
            	Upload upload = s3Service.uploadImage(fileName, f);
            	upload.waitForCompletion();
                Event event = eventService.find(eventId);
                event.setLogoImage(s3Url + fileName);
                eventService.update(event);
                activityService.publish("headline.uploadEventImage");
                return new UploadFileResponse(s3Url + fileName);
            } catch (Exception e) {
                return new UploadFileResponse(e.getMessage());
            }
        } else {
            return new UploadFileResponse("You failed to upload because the file was empty.");
        }
	}
	
	private class UploadFileResponse {
		public String message;
		public UploadFileResponse(String message) {
			this.message = message;
		}
	}
	
	
}
