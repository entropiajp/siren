package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = CandidateListener.class)
@Table(name = "candidate")
public class Candidate {

    /** イベントID */
    @Id
    @Column(name = "event_id")
    Integer eventId;

    /** 楽曲ID */
    @Id
    @Column(name = "tune_id")
    Integer tuneId;

    /** 
     * Returns the eventId.
     * 
     * @return the eventId
     */
    public Integer getEventId() {
        return eventId;
    }

    /** 
     * Sets the eventId.
     * 
     * @param eventId the eventId
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
}