package jp.entropia.sirens.service;

import jp.entropia.sirens.dao.SongDao;
import jp.entropia.sirens.entity.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
	
	@Autowired
	private SongDao songDao;
	
	public boolean save(Song song) {
		return songDao.insert(song) > 0;
	}

}
