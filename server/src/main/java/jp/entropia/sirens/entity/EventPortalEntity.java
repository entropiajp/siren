package jp.entropia.sirens.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;

/**
 */
@Entity
public class EventPortalEntity {

    /** */
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "name")
    String name;

    /** */
    @Column(name = "place")
    String place;

    /** */
    @Column(name = "image_url")
    String imageUrl;

    /** */
    @Column(name = "start_time")
    LocalDateTime startTime;

    /** */
    @Column(name = "end_time")
    LocalDateTime endTime;

    /** */
    @Column(name = "description")
    String description;

    /** */
    @Column(name = "vote_start_time")
    LocalDateTime voteStartTime;

    /** */
    @Column(name = "vote_end_time")
    LocalDateTime voteEndTime;

    /** */
    @Column(name = "vote_limit")
    Integer voteLimit;

    /** */
    @Column(name = "vote_message")
    String voteMessage;

    /** */
    @Column(name = "join_start_time")
    LocalDateTime joinStartTime;

    /** */
    @Column(name = "join_end_time")
    LocalDateTime joinEndTime;

    /** */
    @Column(name = "join_limit")
    Integer joinLimit;

    /** */
    @Column(name = "join_message")
    String joinMessage;

    /** */
    @Column(name = "member_count")
    Integer memberCount;

    /** */
    @Column(name = "is_member")
    boolean isMember;

    /** */
    @Column(name = "is_manager")
    boolean isManager;

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
     * Returns the imageUrl.
     * 
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /** 
     * Sets the imageUrl.
     * 
     * @param imageUrl the imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    /** 
     * Returns the joinStartTime.
     * 
     * @return the joinStartTime
     */
    public LocalDateTime getJoinStartTime() {
        return joinStartTime;
    }

    /** 
     * Sets the joinStartTime.
     * 
     * @param joinStartTime the joinStartTime
     */
    public void setJoinStartTime(LocalDateTime joinStartTime) {
        this.joinStartTime = joinStartTime;
    }

    /** 
     * Returns the joinEndTime.
     * 
     * @return the joinEndTime
     */
    public LocalDateTime getJoinEndTime() {
        return joinEndTime;
    }

    /** 
     * Sets the joinEndTime.
     * 
     * @param joinEndTime the joinEndTime
     */
    public void setJoinEndTime(LocalDateTime joinEndTime) {
        this.joinEndTime = joinEndTime;
    }

    /** 
     * Returns the joinLimit.
     * 
     * @return the joinLimit
     */
    public Integer getJoinLimit() {
        return joinLimit;
    }

    /** 
     * Sets the joinLimit.
     * 
     * @param joinLimit the joinLimit
     */
    public void setJoinLimit(Integer joinLimit) {
        this.joinLimit = joinLimit;
    }

    /** 
     * Returns the joinMessage.
     * 
     * @return the joinMessage
     */
    public String getJoinMessage() {
        return joinMessage;
    }

    /** 
     * Sets the joinMessage.
     * 
     * @param joinMessage the joinMessage
     */
    public void setJoinMessage(String joinMessage) {
        this.joinMessage = joinMessage;
    }

    /** 
     * Returns the memberCount.
     * 
     * @return the memberCount
     */
    public Integer getMemberCount() {
        return memberCount;
    }

    /** 
     * Sets the memberCount.
     * 
     * @param memberCount the memberCount
     */
    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

    
}