package jp.entropia.sirens.controller;

import java.security.Principal;
import java.util.List;

import jp.entropia.sirens.entity.Tune;
import jp.entropia.sirens.entity.TuneWithCandidate;
import jp.entropia.sirens.model.TuneModel;
import jp.entropia.sirens.service.ActivityService;
import jp.entropia.sirens.service.TuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tunes")
public class TuneController {
	
	@Autowired
	private TuneService tuneService;
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 全ての楽曲情報を取得する
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Tune> getAllTunes() {
		return tuneService.findAll();
	}
	
	/**
	 * 楽曲を新規登録する
	 * @param model 楽曲情報
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestBody TuneModel model, Principal principal) {
		Tune tune = new Tune();
		tune.setName(model.getName());
		tune.setTime(tuneService.convertStringToLocalTime(model.getTime()));
		tune.setArtist(model.getArtist());
		tune.setSource(model.getSource());
		tuneService.save(tune);
		activityService.publish(principal.getName(), "headline.addTune", tune.getName());
	}
	
	@RequestMapping(value="/artists", method=RequestMethod.GET)
	public List<String> getStoredArtists() {
		return tuneService.findStoredArtists();
	}
	
	@RequestMapping(value="/sources", method=RequestMethod.GET)
	public List<String> getStoredSources() {
		return tuneService.findStoredSources();
	}
	
	@RequestMapping(value="/with-candidates", method=RequestMethod.GET)
	public List<TuneWithCandidate> getAllTunesWithCandidates(@RequestParam("eventId") Integer eventId) {
		return tuneService.findAll(eventId);
	}

}
