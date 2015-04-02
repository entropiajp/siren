package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.CheckableTune;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.Vote;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.service.MemberService;
import jp.entropia.sirens.service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/votes")
public class VoteController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private VoteService voteService;

	@RequestMapping(value="/{eventId}", method=RequestMethod.POST)
	public void vote(@PathVariable("eventId") Integer eventId,
			@RequestBody List<Integer> votes, Principal principal) {
		Member loginMember = memberService.findByEventIdAndUserId(eventId, principal.getName());
		if(loginMember == null) {
			throw new ForbiddenException();
		}
		
		// TODO 回答上限バリデーション
		
		// TODO トランザクション制御
		voteService.removeAll(loginMember.getId());
		votes.stream().forEach(c -> voteService.save(new Vote(loginMember.getId(), c)));
	}
	
	@RequestMapping(value="/{eventId}", method=RequestMethod.GET)
	public List<CheckableTune> getAllTune(@PathVariable("eventId") Integer eventId,
			Principal principal) {
		Member loginMember = memberService.findByEventIdAndUserId(eventId, principal.getName());
		if(loginMember == null) {
			throw new ForbiddenException();
		}
		return voteService.findAll(loginMember.getId());
	}
}
