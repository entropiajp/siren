package jp.entropia.sirens.controller;

import java.security.Principal;

import jp.entropia.sirens.entity.Role;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.ManagerService;
import jp.entropia.sirens.service.MemberService;
import jp.entropia.sirens.service.RoleService;
import jp.entropia.sirens.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/roles")
public class RoleController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private SongService songService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestBody Role role, Principal principal) {
		roleService.save(role);
		activityService.publish(principal.getName(), "headline.addRole", activityService.getTuneNameAndRoleNameAndEventName(role));
	}
	
	@RequestMapping(value="/{roleId}", method=RequestMethod.PUT)
	public void join(@PathVariable("roleId") Integer roleId, @RequestParam("eventId") Integer eventId, Principal principal) {
		Role role = roleService.select(roleId);
		Integer memberId = memberService.findByEventIdAndUserId(eventId, principal.getName()).getId();
		role.setMemberId(memberId);
		roleService.update(role);
		activityService.publish(principal.getName(), "headline.joinRole", activityService.getTuneNameAndRoleNameAndEventName(role));
	}
	
	@RequestMapping(value="/{roleId}/cancel", method=RequestMethod.POST)
	public void cancel(@PathVariable("roleId") Integer roleId, Principal principal) {
		Role role = roleService.select(roleId);
		role.setMemberId(null);
		roleService.update(role);
		activityService.publish(principal.getName(), "headline.cancelRole", activityService.getTuneNameAndRoleNameAndEventName(role));
	}

}
