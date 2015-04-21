package jp.entropia.sirens.controller;

import java.security.Principal;

import jp.entropia.sirens.entity.Manager;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/managers")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestBody Manager manager, Principal principal) {
		if(managerService.isManager(manager.getEventId(), principal.getName()) == false) {
			throw new ForbiddenException();
		}
		managerService.save(manager);
		activityService.publish(principal.getName(), "headline.addManager", activityService.getEventNameAndManagerName(manager));
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void remove(@RequestParam(required = true, value = "eventId") Integer eventId,
			@RequestParam(required = true, value = "memberId") Integer memberId,
			Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		// TODO ログインユーザ自身を削除できないようバリデーション
		Manager manager = new Manager();
		manager.setEventId(eventId);
		manager.setMemberId(memberId);
		managerService.remove(manager);
		activityService.publish(principal.getName(), "headline.removeManager", activityService.getEventNameAndManagerName(manager));
	}

}
