package jp.entropia.sirens.service;

import jp.entropia.sirens.dao.MemberPartDao;
import jp.entropia.sirens.entity.MemberPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberPartService {

	@Autowired
	private MemberPartDao memberPartDao;
	
	public void removeByEventId(Integer eventId) {
		memberPartDao.deleteByEventId(eventId);
	}
	
	public boolean save(MemberPart entity) {
		return memberPartDao.insert(entity) > 0;
	}
}
