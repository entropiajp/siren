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

    /** アンケート開始日時 */
    @Column(name = "enq_start_time")
    LocalDateTime enqStartTime;

    /** アンケート終了日時 */
    @Column(name = "enq_end_time")
    LocalDateTime enqEndTime;

    /** 説明文 */
    @Column(name = "description")
    String description;

    /** 非公開フラグ */
    @Column(name = "is_private")
    boolean isPrivate;

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
     * Returns the enqStartTime.
     * 
     * @return the enqStartTime
     */
    public LocalDateTime getEnqStartTime() {
        return enqStartTime;
    }

    /** 
     * Sets the enqStartTime.
     * 
     * @param enqStartTime the enqStartTime
     */
    public void setEnqStartTime(LocalDateTime enqStartTime) {
        this.enqStartTime = enqStartTime;
    }

    /** 
     * Returns the enqEndTime.
     * 
     * @return the enqEndTime
     */
    public LocalDateTime getEnqEndTime() {
        return enqEndTime;
    }

    /** 
     * Sets the enqEndTime.
     * 
     * @param enqEndTime the enqEndTime
     */
    public void setEnqEndTime(LocalDateTime enqEndTime) {
        this.enqEndTime = enqEndTime;
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
     * Returns the isPrivate.
     * 
     * @return the isPrivate
     */
    public boolean getIsPrivate() {
        return isPrivate;
    }

    /** 
     * Sets the isPrivate.
     * 
     * @param isPrivate the isPrivate
     */
    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}