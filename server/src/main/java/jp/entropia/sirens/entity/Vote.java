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
    @Column(name = "candidate_id")
    Integer candidateId;

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
     * Returns the candidateId.
     * 
     * @return the candidateId
     */
    public Integer getCandidateId() {
        return candidateId;
    }

    /** 
     * Sets the candidateId.
     * 
     * @param candidateId the candidateId
     */
    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }
}