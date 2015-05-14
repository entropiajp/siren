package jp.entropia.sirens.service;

import jp.entropia.sirens.dao.RoleDao;
import jp.entropia.sirens.entity.EntryInfo;
import jp.entropia.sirens.entity.Manager;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.Role;
import jp.entropia.sirens.entity.User;
import jp.entropia.sirens.model.ActivityModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
	
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UsersService usersService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private EventService eventService;
	@Autowired
	private RoleDao roleDao;
	
	public void publish(String userId, String messageCode, String... args) {
		User user = usersService.getCurrentUser(userId);
		ActivityModel model = new ActivityModel(
				user.getImageUrl(), user.getName(), messageSource.getMessage(messageCode, args, null));
		template.convertAndSend("/topic/activity", model);
	}
	
	public String[] getEventNameAndManagerName(Manager manager) {
		String eventName = eventService.find(manager.getEventId()).getName();
		Member member = memberService.find(manager.getMemberId());
		String managerName = usersService.getCurrentUser(member.getUserid()).getName();
		String[] result = {eventName, managerName};
		return result;
	}
	
	public String[] getTuneNameAndRoleNameAndEventName(Role role) {
		EntryInfo info = roleDao.selectEntryInfoById(role.getId());
		String[] result = {info.getTuneName(), info.getRoleName(), info.getEventName()};
		return result;
	}

}
