package jp.entropia.sirens.service;

import java.time.ZoneId;
import java.util.List;

import jp.entropia.sirens.dao.MemberDao;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.MemberEntity;
import jp.entropia.sirens.model.MemberModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	public int save(Member member){
		return memberDao.insert(member);
	}
	
	public List<MemberEntity> findAllJoinedMember(Integer eventId) {
		return memberDao.selectAllJoinedMember(eventId);
	}
	
	public Member find(Integer id) {
		return memberDao.selectById(id);
	}
	
	// TODO メンバ削除時に関連テーブルのレコードも全て削除する
	public int remove(Member member) {
		return memberDao.delete(member);
	}
	
	public Member findByEventIdAndUserId(Integer eventId, String userId) {
		return memberDao.selectByEventIdAndUserId(eventId, userId);
	}

	public MemberModel convertObject(Member member) {
        MemberModel model = new MemberModel();
        BeanUtils.copyProperties(member, model);
        if(member.getStartTime() != null) {
            model.setStartTime(member.getStartTime().atZone(ZoneId.of("Z")));
        }
        if(member.getEndTime() != null) {
            model.setEndTime(member.getEndTime().atZone(ZoneId.of("Z")));
        }
        return model;
    }

	public boolean update(Member member) {
		return memberDao.update(member) > 0;
	}
}
