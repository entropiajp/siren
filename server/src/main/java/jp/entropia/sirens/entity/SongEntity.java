package jp.entropia.sirens.entity;

import java.time.LocalTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity
public class SongEntity {
	
	/** 演奏曲ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** イベントID */
    @Column(name = "event_id")
    Integer eventId;

    /** 曲ID */
    @Column(name = "tune_id")
    Integer tuneId;

    /** 演奏フラグ */
    @Column(name = "playable")
    boolean playable;

    /** 演奏順 */
    @Column(name = "song_order")
    Integer songOrder;
	
	/** 曲名 */
    @Column(name = "name")
    String name;

    /** 演奏時間 */
    @Column(name = "time")
    LocalTime time;

    /** アーティスト */
    @Column(name = "artist")
    String artist;

    /** 作品 */
    @Column(name = "source")
    String source;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getTuneId() {
		return tuneId;
	}

	public void setTuneId(Integer tuneId) {
		this.tuneId = tuneId;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public Integer getSongOrder() {
		return songOrder;
	}

	public void setSongOrder(Integer songOrder) {
		this.songOrder = songOrder;
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

}
