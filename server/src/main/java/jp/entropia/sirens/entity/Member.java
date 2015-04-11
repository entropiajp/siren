package jp.entropia.sirens.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = MemberListener.class)
@Table(name = "member")
public class Member {

    /** メンバID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** イベントID */
    @Column(name = "event_id")
    Integer eventId;

    /** userId */
    @Column(name = "userId")
    String userid;

    /** 打ち上げ参加 */
    @Column(name = "attend_party")
    String attendParty;

    /** 参加開始時刻 */
    @Column(name = "start_time")
    LocalDateTime startTime;

    /** 参加終了時刻 */
    @Column(name = "end_time")
    LocalDateTime endTime;

    /** 備考 */
    @Column(name = "free_space")
    String freeSpace;

    /** 主催用メモ */
    @Column(name = "memo_by_manager")
    String memoByManager;

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
     * Returns the userid.
     * 
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /** 
     * Sets the userid.
     * 
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /** 
     * Returns the attendParty.
     * 
     * @return the attendParty
     */
    public String getAttendParty() {
        return attendParty;
    }

    /** 
     * Sets the attendParty.
     * 
     * @param attendParty the attendParty
     */
    public void setAttendParty(String attendParty) {
        this.attendParty = attendParty;
    }

    /** 
     * Returns the startTime.
     * 
     * @return the startTime
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /** 
     * Sets the startTime.
     * 
     * @param startTime the startTime
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /** 
     * Returns the endTime.
     * 
     * @return the endTime
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /** 
     * Sets the endTime.
     * 
     * @param endTime the endTime
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /** 
     * Returns the freeSpace.
     * 
     * @return the freeSpace
     */
    public String getFreeSpace() {
        return freeSpace;
    }

    /** 
     * Sets the freeSpace.
     * 
     * @param freeSpace the freeSpace
     */
    public void setFreeSpace(String freeSpace) {
        this.freeSpace = freeSpace;
    }

    /** 
     * Returns the memoByManager.
     * 
     * @return the memoByManager
     */
    public String getMemoByManager() {
        return memoByManager;
    }

    /** 
     * Sets the memoByManager.
     * 
     * @param memoByManager the memoByManager
     */
    public void setMemoByManager(String memoByManager) {
        this.memoByManager = memoByManager;
    }
}