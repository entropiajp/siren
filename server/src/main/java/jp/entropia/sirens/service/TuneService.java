package jp.entropia.sirens.service;

import java.time.LocalTime;
import java.util.List;

import jp.entropia.sirens.dao.TuneDao;
import jp.entropia.sirens.entity.Tune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuneService {

	@Autowired
	private TuneDao tuneDao;
	
	public List<Tune> findAll() {
		return tuneDao.selectAll();
	}

	public boolean save(Tune tune) {
		return tuneDao.insert(tune) > 0;
	}
	
	/**
	 * "mm:ss"形式の文字列をLocalTimeに変換する
	 * @param time
	 * @return
	 */
	public LocalTime convertStringToLocalTime(String time) {
		String[] minuteAndSecond = time.split(":");
		if(minuteAndSecond.length < 2) {
			throw new IllegalArgumentException();
		} else {
			return LocalTime.of(
					0, Integer.parseInt(minuteAndSecond[0]), Integer.parseInt(minuteAndSecond[1]));
		}
	}
	
	public List<String> findStoredArtists() {
		return tuneDao.selectStoredArtists();
	}
	
	public List<String> findStoredSources() {
		return tuneDao.selectStoredSources();
	}
}
