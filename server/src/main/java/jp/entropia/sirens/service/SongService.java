package jp.entropia.sirens.service;

import java.util.List;
import java.util.stream.Collectors;

import jp.entropia.sirens.dao.RoleDao;
import jp.entropia.sirens.dao.SongDao;
import jp.entropia.sirens.entity.Song;
import jp.entropia.sirens.entity.SongEntity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SongService {
	
	@Autowired
	private SongDao songDao;
	@Autowired
	private RoleDao roleDao;
	
	public boolean save(Song song) {
		return songDao.insert(song) > 0;
	}

	public List<SongEntity> findAll(Integer eventId) {
		return songDao.selectAll(eventId);
	}
	
	public Song find(Integer songId) {
		return songDao.selectById(songId);
	}

	public boolean update(Song song) {
		return songDao.update(song) > 0;
	}
	
	public void removeByEventId(Integer eventId) {
		songDao.deleteByEventId(eventId);
	}
	
	public void saveAll(Integer eventId, List<Integer> tuneIds) {
		List<SongEntity> oldSongs = findAll(eventId);
		
		// 最新の候補曲で追加された曲はinsert
		List<Integer> oldSongsTuneId = oldSongs.stream().map(e -> e.getTuneId()).collect(Collectors.toList());
		tuneIds.stream()
				.filter(e -> !oldSongsTuneId.contains(e))
				.forEach(e -> save(new Song(eventId, e)));
		
		// 最新の候補曲で削除された曲はrole情報も含めてdelete
		oldSongs.stream()
				.map(e -> convert(e))
				.filter(e -> !tuneIds.contains(e.getTuneId()))
				.forEach(e -> remove(e));
	}
	
	public void remove(Song song) {
		roleDao.deleteBySongId(song.getId());
		songDao.delete(song);
	}
	
	public Song convert(SongEntity entity) {
		Song song = new Song();
		BeanUtils.copyProperties(entity, song);
		return song;
	}

}
