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
@Entity(listener = EventListener.class)
@Table(name = "event")
public class Event {

    /** イベントID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** イベント名 */
    @Column(name = "name")
    String name;

    /** 場所 */
    @Column(name = "place")
    String place;

    /** 開始時刻 */
    @Column(name = "start_time")
    LocalDateTime startTime;

    /** 終了時刻 */
    @Column(name = "end_time")
    LocalDateTime endTime;

    /** ロゴ画像 */
    @Column(name = "logo_image")
    String logoImage;

    /** 投票開始日時 */
    @Column(name = "vote_start_time")
    LocalDateTime voteStartTime;

    /** 投票終了日時 */
    @Column(name = "vote_end_time")
    LocalDateTime voteEndTime;

    /** 投票上限曲数 */
    @Column(name = "vote_limit")
    Integer voteLimit;

    /** 説明文 */
    @Column(name = "description")
    String description;

    /** 投票注意文 */
    @Column(name = "vote_message")
    String voteMessage;

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
     * Returns the place.
     * 
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /** 
     * Sets the place.
     * 
     * @param place the place
     */
    public void setPlace(String place) {
        this.place = place;
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
     * Returns the logoImage.
     * 
     * @return the logoImage
     */
    public String getLogoImage() {
        return logoImage;
    }

    /** 
     * Sets the logoImage.
     * 
     * @param logoImage the logoImage
     */
    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    /** 
     * Returns the voteStartTime.
     * 
     * @return the voteStartTime
     */
    public LocalDateTime getVoteStartTime() {
        return voteStartTime;
    }

    /** 
     * Sets the voteStartTime.
     * 
     * @param voteStartTime the voteStartTime
     */
    public void setVoteStartTime(LocalDateTime voteStartTime) {
        this.voteStartTime = voteStartTime;
    }

    /** 
     * Returns the voteEndTime.
     * 
     * @return the voteEndTime
     */
    public LocalDateTime getVoteEndTime() {
        return voteEndTime;
    }

    /** 
     * Sets the voteEndTime.
     * 
     * @param voteEndTime the voteEndTime
     */
    public void setVoteEndTime(LocalDateTime voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    /** 
     * Returns the voteLimit.
     * 
     * @return the voteLimit
     */
    public Integer getVoteLimit() {
        return voteLimit;
    }

    /** 
     * Sets the voteLimit.
     * 
     * @param voteLimit the voteLimit
     */
    public void setVoteLimit(Integer voteLimit) {
        this.voteLimit = voteLimit;
    }

    /** 
     * Returns the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /** 
     * Sets the description.
     * 
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
     * Returns the voteMessage.
     * 
     * @return the voteMessage
     */
    public String getVoteMessage() {
        return voteMessage;
    }

    /** 
     * Sets the voteMessage.
     * 
     * @param voteMessage the voteMessage
     */
    public void setVoteMessage(String voteMessage) {
        this.voteMessage = voteMessage;
    }
}