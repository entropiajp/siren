package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = MemberPartListener.class)
@Table(name = "member_part")
public class MemberPart {

    /** メンバID */
    @Id
    @Column(name = "member_id")
    Integer memberId;

    /** 楽器歌唱パートID */
    @Id
    @Column(name = "part_id")
    Integer partId;

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
     * Returns the partId.
     * 
     * @return the partId
     */
    public Integer getPartId() {
        return partId;
    }

    /** 
     * Sets the partId.
     * 
     * @param partId the partId
     */
    public void setPartId(Integer partId) {
        this.partId = partId;
    }
}