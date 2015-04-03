package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.EventDao;
import jp.entropia.sirens.entity.Event;
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
	
	
}
