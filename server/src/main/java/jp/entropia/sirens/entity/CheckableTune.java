package jp.entropia.sirens.entity;

import java.time.LocalTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class CheckableTune {

	@Id
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "track_no")
	private Integer trackNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "artist")
	private String artist;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "is_voted")
	private boolean isVoted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTrackNo() {
		return trackNo;
	}

	public void setTrackNo(Integer trackNo) {
		this.trackNo = trackNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isVoted() {
		return isVoted;
	}

	public void setVoted(boolean isVoted) {
		this.isVoted = isVoted;
	}
	
	
}
