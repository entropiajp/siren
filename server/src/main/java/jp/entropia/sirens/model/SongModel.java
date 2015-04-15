package jp.entropia.sirens.model;

import java.util.List;

import jp.entropia.sirens.entity.RoleEntity;
import jp.entropia.sirens.entity.SongEntity;

public class SongModel {
	
	private SongEntity song;
	private List<RoleEntity> roles;
	
	public SongModel(){};
	public SongModel(SongEntity song, List<RoleEntity> roles) {
		this.song = song;
		this.roles = roles;
	}

	public SongEntity getSong() {
		return song;
	}
	public void setSong(SongEntity song) {
		this.song = song;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	} 

}
