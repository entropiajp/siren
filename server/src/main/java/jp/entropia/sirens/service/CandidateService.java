package jp.entropia.sirens.service;

import jp.entropia.sirens.dao.CandidateDao;
import jp.entropia.sirens.entity.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

	@Autowired
	private CandidateDao candidateDao;
	
	/**
	 * 特定のイベントの候補曲を全て削除する
	 * @param eventId イベントID
	 * @return
	 */
	public boolean removeAll(Integer eventId) {
		return candidateDao.deleteAll(eventId) > 0;
	}

	public boolean save(Candidate candidate) {
		return candidateDao.insert(candidate) > 0;
	}
}
