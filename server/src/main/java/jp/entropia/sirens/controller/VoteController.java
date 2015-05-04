package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import jp.entropia.sirens.entity.CheckableTune;
import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.Vote;
import jp.entropia.sirens.entity.VoteResult;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.exception.VoteLimitExceededException;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.EventService;
import jp.entropia.sirens.service.ManagerService;
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
	@Autowired
	private EventService eventService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value="/{eventId}", method=RequestMethod.POST)
	public void vote(@PathVariable("eventId") Integer eventId,
			@RequestBody List<Integer> voteIds, Principal principal) {
		Member loginMember = memberService.findByEventIdAndUserId(eventId, principal.getName());
		if(loginMember == null) {
			throw new ForbiddenException();
		}
		
		Event event = eventService.find(eventId);
		if(event.getVoteLimit() != null && voteIds.size() > event.getVoteLimit()) {
			throw new VoteLimitExceededException();
		}
		
		List<Vote> votes = voteIds.stream().map(c -> new Vote(loginMember.getId(), c)).collect(Collectors.toList());
		voteService.saveAll(votes);
		activityService.publish(principal.getName(), "headline.vote", event.getName());
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
	
	@RequestMapping(value="/{eventId}/result", method=RequestMethod.GET)
	public List<VoteResult> getResult(@PathVariable("eventId") Integer eventId,
			Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		return voteService.findResult(eventId);
	}
}
