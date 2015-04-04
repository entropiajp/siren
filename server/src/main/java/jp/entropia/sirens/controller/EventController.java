package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.Manager;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.model.EventModel;
import jp.entropia.sirens.service.EventService;
import jp.entropia.sirens.service.ManagerService;
import jp.entropia.sirens.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/event")
public class EventController {

	@Autowired
	private EventService eventService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ManagerService managerService;
	
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
	}
	
	@RequestMapping(value="/{eventId}", method=RequestMethod.PUT)
	public void update(@PathVariable("eventId") Integer eventId, @RequestBody EventModel model, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		eventService.update(eventService.convertObject(model));
	}
	
	@RequestMapping(value="/{eventId}", method=RequestMethod.GET)
	public Event get(@PathVariable("eventId") Integer eventId) {
		Event event = eventService.find(eventId);
		return event;
	}
	
	@RequestMapping(value="/managed", method=RequestMethod.GET)
	public List<Event> getEventManagedByLoginUser(Principal principal) {
		return eventService.findManagedEvents(principal.getName());
	}
	
	@RequestMapping(value="/joined", method=RequestMethod.GET)
	public List<Event> getEventJoinedByLoginUser(Principal principal) {
		return eventService.findJoinedEvents(principal.getName());
	}
	
	@RequestMapping(value="/past", method=RequestMethod.GET)
	public List<Event> getPastEvent() {
		return eventService.findPastEvents();
	}
	
	@RequestMapping(value="/future", method=RequestMethod.GET)
	public List<Event> getFutureEvent() {
		return eventService.findFutureEvents();
	}
	
	@RequestMapping(value="/{eventId}/is-manager", method=RequestMethod.GET)
	public void isCurrentUserManager(@PathVariable("eventId") Integer eventId, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
	}
	
	
}
