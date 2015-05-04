package jp.entropia.sirens.service;

import jp.entropia.sirens.dao.MemberPartDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberPartService {

	@Autowired
	private MemberPartDao memberPartDao;
	
	public void removeByEventId(Integer eventId) {
		memberPartDao.deleteByEventId(eventId);
	}
}
