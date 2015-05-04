package jp.entropia.sirens.service;

import java.util.List;

import jp.entropia.sirens.dao.SongDao;
import jp.entropia.sirens.entity.Song;
import jp.entropia.sirens.entity.SongEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SongService {
	
	@Autowired
	private SongDao songDao;
	
	public boolean save(Song song) {
		return songDao.insert(song) > 0;
	}

	public List<SongEntity> findAll(Integer eventId) {
		return songDao.selectAll(eventId);
	}
	
	public Song find(Integer songId) {
		return songDao.selectById(songId);
	}

	public Object update(Song song) {
		return songDao.update(song) > 0;
	}
	
	public void removeByEventId(Integer eventId) {
		songDao.deleteByEventId(eventId);
	}

}
