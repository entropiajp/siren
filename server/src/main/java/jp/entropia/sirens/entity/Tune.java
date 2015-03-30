package jp.entropia.sirens.entity;

import java.time.LocalTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = TuneListener.class)
@Table(name = "tune")
public class Tune {

    /** 曲ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** トラックNo */
    @Column(name = "track_no")
    Integer trackNo;

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

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Returns the trackNo.
     * 
     * @return the trackNo
     */
    public Integer getTrackNo() {
        return trackNo;
    }

    /** 
     * Sets the trackNo.
     * 
     * @param trackNo the trackNo
     */
    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    /** 
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the time.
     * 
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /** 
     * Sets the time.
     * 
     * @param time the time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /** 
     * Returns the artist.
     * 
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /** 
     * Sets the artist.
     * 
     * @param artist the artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /** 
     * Returns the source.
     * 
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /** 
     * Sets the source.
     * 
     * @param source the source
     */
    public void setSource(String source) {
        this.source = source;
    }
}