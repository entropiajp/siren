package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.MemberModel;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.ManagerService;
import jp.entropia.sirens.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * イベントの全参加者を取得する
	 * @param eventId イベントID
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<MemberModel> getAllJoinedMember(
			@RequestParam(required = false, value = "eventId") Integer eventId){
		return memberService.findAllJoinedMember(eventId);
	}
	
	/**
	 * ログインユーザをイベントに登録する
	 * @param eventId イベントID
	 * @param principal
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void join(@RequestParam(required = true, value = "eventId") Integer eventId,
			Principal principal) {
		Member member = new Member();
		member.setEventId(eventId);
		member.setUserid(principal.getName());
		memberService.save(member);
		activityService.publish("headline.join");
	}
	
	/**
	 * 参加者をキャンセルする
	 * @param memberId メンバID
	 * @param principal
	 */
	@RequestMapping(value="/{memberId}", method=RequestMethod.DELETE)
	public void cancel(@PathVariable("memberId") Integer memberId,
			Principal principal) {
		Member member = memberService.select(memberId);
		if(managerService.isManager(member.getEventId(), principal.getName()) == false) {
			throw new ForbiddenException();
		}
		memberService.remove(member);
		activityService.publish("headline.cancel");
	}

}
