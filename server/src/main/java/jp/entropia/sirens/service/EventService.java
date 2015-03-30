package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.EventDao;
import jp.entropia.sirens.entity.Event;

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
	
	
}
