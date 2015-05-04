package jp.entropia.sirens.service;

import java.time.ZoneId;
import java.util.List;

import jp.entropia.sirens.dao.EventDao;
import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.EventPortalEntity;
import jp.entropia.sirens.entity.Manager;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.model.EventModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventService {

	@Autowired
	private EventDao eventDao;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private SongService songService;
	@Autowired
	private MemberPartService memberPartService;
	
	public boolean save(Event event) {
		return eventDao.insert(event) > 0;
	}
	
	public Event find(Integer eventId) {
		return eventDao.selectById(eventId);
	}
	
	public EventPortalEntity find(Integer eventId, String userId) {
		return eventDao.selectByIdAndUserId(eventId, userId);
	}
	
	public boolean update(Event event) {
		return eventDao.update(event) > 0;
	}
	
	public List<Event> findManagedEvents(String userId) {
		return eventDao.selectManagedEvent(userId);
	}
	
	public List<Event> findJoinedEvents(String userId) {
		return eventDao.selectJoinedEvents(userId);
	}
	
	public Event convertObject(EventModel model) {
		Event event = new Event();
		BeanUtils.copyProperties(model, event);
		event.setStartTime(model.getStartTime().toLocalDateTime());
		event.setEndTime(model.getEndTime().toLocalDateTime());
		if(model.getVoteStartTime() != null) {
			event.setVoteStartTime(model.getVoteStartTime().toLocalDateTime());
		}
		if(model.getVoteEndTime() != null) {
			event.setVoteEndTime(model.getVoteEndTime().toLocalDateTime());
		}
		if(model.getJoinStartTime() != null) {
            event.setJoinStartTime(model.getJoinStartTime().toLocalDateTime());
        }
        if(model.getJoinEndTime() != null) {
            event.setJoinEndTime(model.getJoinEndTime().toLocalDateTime());
        }
		return event;
	}
	
	public EventModel convertObject(Event event) {
		EventModel model = new EventModel();
		BeanUtils.copyProperties(event, model);
		model.setStartTime(event.getStartTime().atZone(ZoneId.of("Z")));
		model.setEndTime(event.getEndTime().atZone(ZoneId.of("Z")));
		if(event.getVoteStartTime() != null) {
			model.setVoteStartTime(event.getVoteStartTime().atZone(ZoneId.of("Z")));
		}
		if(event.getVoteEndTime() != null) {
			model.setVoteEndTime(event.getVoteEndTime().atZone(ZoneId.of("Z")));
		}
		if(event.getJoinStartTime() != null) {
            model.setJoinStartTime(event.getJoinStartTime().atZone(ZoneId.of("Z")));
        }
        if(event.getJoinEndTime() != null) {
            model.setJoinEndTime(event.getJoinEndTime().atZone(ZoneId.of("Z")));
        }
		return model;
	}

	public List<EventPortalEntity> findAll(String userId) {
		return eventDao.selectAll(userId);
	}

	public EventModel convertObject(EventPortalEntity entity) {
		EventModel model = new EventModel();
		BeanUtils.copyProperties(entity, model);
		model.setStartTime(entity.getStartTime().atZone(ZoneId.of("Z")));
		model.setEndTime(entity.getEndTime().atZone(ZoneId.of("Z")));
		if(entity.getVoteStartTime() != null) {
			model.setVoteStartTime(entity.getVoteStartTime().atZone(ZoneId.of("Z")));
		}
		if(entity.getVoteEndTime() != null) {
			model.setVoteEndTime(entity.getVoteEndTime().atZone(ZoneId.of("Z")));
		}
		if(entity.getJoinStartTime() != null) {
            model.setJoinStartTime(entity.getJoinStartTime().atZone(ZoneId.of("Z")));
        }
        if(entity.getJoinEndTime() != null) {
            model.setJoinEndTime(entity.getJoinEndTime().atZone(ZoneId.of("Z")));
        }
		return model;	
	}
	
	public void create(Event event, String userId) {
		save(event);
		
		// バンオフ作成者は参加者としても登録
		Member member = new Member();
		member.setEventId(event.getId());
		member.setUserid(userId);
		member.setAttendParty("参加");
		member.setStartTime(event.getStartTime());
		member.setEndTime(event.getEndTime());
		memberService.save(member);
		
		// バンオフ作成者は管理者になる
		Manager manager = new Manager();
		manager.setEventId(event.getId());
		manager.setMemberId(member.getId());
		managerService.save(manager);
	}
	
	public void remove(Integer eventId) {
		eventDao.delete(eventDao.selectById(eventId));
	}
	
	public void removeEventAndRelated(Integer eventId) {
		managerService.removeByEventId(eventId);
		memberPartService.removeByEventId(eventId);
		roleService.removeByEventId(eventId);
		voteService.removeByEventId(eventId);
		memberService.removeByEventId(eventId);
		songService.removeByEventId(eventId);
		remove(eventId);
	}
	
	
}
