package jp.entropia.sirens.service;

import java.time.ZoneId;
import java.util.List;

import jp.entropia.sirens.dao.ManagerDao;
import jp.entropia.sirens.dao.MemberDao;
import jp.entropia.sirens.dao.MemberPartDao;
import jp.entropia.sirens.dao.RoleDao;
import jp.entropia.sirens.dao.VoteDao;
import jp.entropia.sirens.entity.Manager;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.MemberEntity;
import jp.entropia.sirens.entity.MemberPart;
import jp.entropia.sirens.model.MemberModel;
import jp.entropia.sirens.model.PartModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPartDao memberPartDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private VoteDao voteDao;
	@Autowired
	private ManagerDao managerDao;
	
	public int save(Member member){
		return memberDao.insert(member);
	}
	
	public List<MemberEntity> findAllJoinedMember(Integer eventId) {
		return memberDao.selectAllJoinedMember(eventId);
	}
	
	public Member find(Integer id) {
		return memberDao.selectById(id);
	}
	
	public void remove(Member member) {
		Integer memberId = member.getId();
		Manager manager = new Manager();
		manager.setEventId(member.getEventId());
		manager.setMemberId(memberId);
		
		roleDao.cancelByMemberId(memberId);
		voteDao.deleteByMemberId(memberId);
		memberPartDao.deleteByMemberId(memberId);
		managerDao.delete(manager);
		memberDao.delete(member);
	}
	
	public Member findByEventIdAndUserId(Integer eventId, String userId) {
		return memberDao.selectByEventIdAndUserId(eventId, userId);
	}
	
	public void removeByEventId(Integer eventId) {
		memberDao.deleteByEventId(eventId);
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

	public void join(Member member, List<PartModel> model) {
		save(member);
		model.stream().forEach(e -> memberPartDao.insert(new MemberPart(member.getId(), e.getId())));
	}
	
	/**
	 * ユーザがイベントの参加者であるか判定する
	 * @param eventId イベントID
	 * @param userId ユーザID
	 * @return
	 */
	public boolean isMember(Integer eventId, String userId) {
		return findByEventIdAndUserId(eventId, userId) != null;
	}
}
