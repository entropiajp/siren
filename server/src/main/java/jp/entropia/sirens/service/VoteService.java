package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.VoteDao;
import jp.entropia.sirens.entity.CheckableTune;
import jp.entropia.sirens.entity.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

	@Autowired
	private VoteDao voteDao;
	
	/**
	 * 特定のメンバーの投票曲を全て削除する
	 * @param memberId メンバID
	 * @return
	 */
	public boolean removeAll(Integer memberId) {
		return voteDao.deleteAll(memberId) > 0;
	}

	public boolean save(Vote vote) {
		return voteDao.insert(vote) > 0;
	}

	/**
	 * 特定のメンバーの投票情報付きですべての曲を取得する
	 * @param memberId メンバID
	 * @return
	 */
	public List<CheckableTune> findAll(Integer memberId) {
		return voteDao.selectAllTunesWithVotes(memberId);
	}
}
