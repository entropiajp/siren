package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.MemberEntity;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.exception.NotMemberException;
import jp.entropia.sirens.model.MemberModel;
import jp.entropia.sirens.model.PartModel;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.EventService;
import jp.entropia.sirens.service.ManagerService;
import jp.entropia.sirens.service.MemberPartService;
import jp.entropia.sirens.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private EventService eventService;
	@Autowired
	private MemberPartService memberPartService;
	
	/**
	 * イベントの全参加者を取得する
	 * @param eventId イベントID
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<MemberEntity> getAllJoinedMember(
			@RequestParam(required = false, value = "eventId") Integer eventId){
		return memberService.findAllJoinedMember(eventId);
	}
	
	/**
	 * ログインユーザを参加者としてイベントに登録する
	 * @param eventId イベントID
	 * @param principal
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void join(@RequestParam(required = true, value = "eventId") Integer eventId,
			@RequestBody List<PartModel> model, Principal principal) {
		Event event = eventService.find(eventId);
		
		// メンバ情報を保存
		Member member = new Member();
		member.setEventId(eventId);
		member.setUserid(principal.getName());
		member.setStartTime(event.getStartTime());
		member.setEndTime(event.getEndTime());
		member.setAttendParty("未定");
		memberService.join(member, model);
		
		activityService.publish(principal.getName(), "headline.join", event.getName());
	}
	
	/**
	 * 参加者をキャンセルする
	 * @param memberId メンバID
	 * @param principal
	 */
	@RequestMapping(value="/{memberId}", method=RequestMethod.DELETE)
	public void cancel(@PathVariable("memberId") Integer memberId,
			Principal principal) {
		Member member = memberService.find(memberId);
		if(managerService.isManager(member.getEventId(), principal.getName()) == false) {
			throw new ForbiddenException();
		}
		memberService.remove(member);
		Event event = eventService.find(member.getEventId());
		activityService.publish(principal.getName(), "headline.cancel", event.getName());
	}
	
	/**
	 * ログインユーザのイベント参加者としての情報を取得する
	 * @param eventId イベントID
	 * @param principal
	 * @return
	 */
	@RequestMapping(value="/my", method=RequestMethod.GET)
	public MemberModel getCurrentMember(@RequestParam(required = true, value = "eventId") Integer eventId,
			Principal principal) {
		Member member = memberService.findByEventIdAndUserId(eventId, principal.getName());
		if(member == null) {
			throw new NotMemberException();
		}
		return memberService.convertObject(member);
	}
	
	/**
	 * メンバ情報を更新する
	 * @param memberId メンバID
	 * @param model 受信データ
	 * @param principal
	 */
	@RequestMapping(value="/{memberId}", method=RequestMethod.PUT)
	public void update(@PathVariable("memberId") Integer memberId, @RequestBody MemberModel model, Principal principal) {
		Member member = memberService.find(memberId);
		if(member == null) {
			throw new ForbiddenException();
		}
		member.setStartTime(model.getStartTime().toLocalDateTime());
		member.setEndTime(model.getEndTime().toLocalDateTime());
		member.setAttendParty(model.getAttendParty());
		member.setFreeSpace(model.getFreeSpace());
		memberService.update(member);
	}

}
