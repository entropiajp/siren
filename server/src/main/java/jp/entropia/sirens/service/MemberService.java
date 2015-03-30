package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.MemberDao;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.MemberModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	public int save(Member member){
		return memberDao.insert(member);
	}
	
	public List<MemberModel> findAllJoinedMember(Integer eventId) {
		return memberDao.selectAllJoinedMember(eventId);
	}
	
	public Member select(Integer id) {
		return memberDao.selectById(id);
	}
	
	// TODO メンバ削除時に関連テーブルのレコードも全て削除する
	public int remove(Member member) {
		return memberDao.delete(member);
	}
}
