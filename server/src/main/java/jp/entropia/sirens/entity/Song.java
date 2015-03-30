package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = SongListener.class)
@Table(name = "song")
public class Song {

    /** 演奏曲ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 曲ID */
    @Column(name = "tune_id")
    Integer tuneId;

    /** 演奏フラグ */
    @Column(name = "is_played")
    Integer isPlayed;

    /** 演奏順 */
    @Column(name = "song_order")
    Integer songOrder;

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
     * Returns the tuneId.
     * 
     * @return the tuneId
     */
    public Integer getTuneId() {
        return tuneId;
    }

    /** 
     * Sets the tuneId.
     * 
     * @param tuneId the tuneId
     */
    public void setTuneId(Integer tuneId) {
        this.tuneId = tuneId;
    }

    /** 
     * Returns the isPlayed.
     * 
     * @return the isPlayed
     */
    public Integer getIsPlayed() {
        return isPlayed;
    }

    /** 
     * Sets the isPlayed.
     * 
     * @param isPlayed the isPlayed
     */
    public void setIsPlayed(Integer isPlayed) {
        this.isPlayed = isPlayed;
    }

    /** 
     * Returns the songOrder.
     * 
     * @return the songOrder
     */
    public Integer getSongOrder() {
        return songOrder;
    }

    /** 
     * Sets the songOrder.
     * 
     * @param songOrder the songOrder
     */
    public void setSongOrder(Integer songOrder) {
        this.songOrder = songOrder;
    }
}