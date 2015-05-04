package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.RoleEntity;
import jp.entropia.sirens.entity.Song;
import jp.entropia.sirens.entity.SongEntity;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.model.SongModel;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.EventService;
import jp.entropia.sirens.service.ManagerService;
import jp.entropia.sirens.service.RoleService;
import jp.entropia.sirens.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/songs")
public class SongController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private SongService songService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestParam("eventId") Integer eventId, @RequestBody List<Integer> selectedTuneIds, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		songService.saveAll(eventId, selectedTuneIds);
		Event event = eventService.find(eventId);
		activityService.publish(principal.getName(), "headline.addSongs", event.getName());
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<SongModel> getAll(@RequestParam("eventId") Integer eventId) {
		// TODO メンバーチェック
		List<SongEntity> songs = songService.findAll(eventId);
		Map<Integer, List<RoleEntity>> rolesMap = roleService.findAll(eventId).stream()
				.collect(Collectors.groupingBy(RoleEntity::getSongId));
		return songs.stream().map(e -> new SongModel(e, rolesMap.get(e.getId()))).collect(Collectors.toList());
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void update(@RequestParam("eventId") Integer eventId, @RequestBody List<Song> songs, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		songs.stream().forEach(e -> songService.update(e));
		Event event = eventService.find(eventId);
		activityService.publish(principal.getName(), "headline.updateSongs", event.getName());
	}

}
