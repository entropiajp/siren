package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = VoteListener.class)
@Table(name = "vote")
public class Vote {

    /**  */
    @Id
    @Column(name = "member_id")
    Integer memberId;

    /**  */
    @Id
    @Column(name = "tune_id")
    Integer tuneId;
    
    public Vote(){}
    public Vote(Integer memberId, Integer tuneId) {
    	this.memberId = memberId;
    	this.tuneId = tuneId;
    }

    /** 
     * Returns the memberId.
     * 
     * @return the memberId
     */
    public Integer getMemberId() {
        return memberId;
    }

    /** 
     * Sets the memberId.
     * 
     * @param memberId the memberId
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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