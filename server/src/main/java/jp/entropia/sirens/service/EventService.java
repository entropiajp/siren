package jp.entropia.sirens.service;

import java.time.ZoneId;
import java.util.List;

import jp.entropia.sirens.dao.EventDao;
import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.EventPortalEntity;
import jp.entropia.sirens.model.EventModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private EventDao eventDao;
	
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

	public List<Event> findPastEvents() {
		return eventDao.selectPastEvents();
	}
	
	public List<Event> findFutureEvents() {
		return eventDao.selectFutureEvents();
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
		return model;	
	}
	
	
}
