package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.Song;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.ManagerService;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestParam("eventId") Integer eventId, @RequestBody List<Integer> selectedTuneIds, Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		selectedTuneIds.stream().forEach(e -> songService.save(new Song(eventId, e)));
		activityService.publish("headline.addSongs");
	}

}
