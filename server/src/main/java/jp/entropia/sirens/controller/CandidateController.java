package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.Candidate;
import jp.entropia.sirens.exception.ForbiddenException;
import jp.entropia.sirens.service.CandidateService;
import jp.entropia.sirens.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private ManagerService managerService;

	@RequestMapping(value="/{eventId}", method=RequestMethod.POST)
	public void saveAfterDelete(@PathVariable("eventId") Integer eventId,
			@RequestBody List<Candidate> candidates,
			Principal principal) {
		if(managerService.isManager(eventId, principal.getName()) == false) {
			throw new ForbiddenException();
		}
		// TODO トランザクション制御
		candidateService.removeAll(eventId);
		candidates.stream().forEach(c -> candidateService.save(c));
	}
}
