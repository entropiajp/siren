package jp.entropia.sirens.model;

import java.time.ZonedDateTime;

public class EventModel {

	private Integer id;
	private String name;
	private String place;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private String imageUrl;
	private String description;
	private ZonedDateTime voteStartTime;
	private ZonedDateTime voteEndTime;
	private String voteMessage;
	private Integer voteLimit;
	private ZonedDateTime joinStartTime;
    private ZonedDateTime joinEndTime;
    private String joinMessage;
    private Integer joinLimit;
	private Integer memberCount;
	private boolean isMember;
	private boolean isManager;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ZonedDateTime getVoteStartTime() {
		return voteStartTime;
	}
	public void setVoteStartTime(ZonedDateTime voteStartTime) {
		this.voteStartTime = voteStartTime;
	}
	public ZonedDateTime getVoteEndTime() {
		return voteEndTime;
	}
	public void setVoteEndTime(ZonedDateTime voteEndTime) {
		this.voteEndTime = voteEndTime;
	}
	public String getVoteMessage() {
		return voteMessage;
	}
	public void setVoteMessage(String voteMessage) {
		this.voteMessage = voteMessage;
	}
	public Integer getVoteLimit() {
		return voteLimit;
	}
	public void setVoteLimit(Integer voteLimit) {
		this.voteLimit = voteLimit;
	}
	public ZonedDateTime getJoinStartTime() {
		return joinStartTime;
	}
	public void setJoinStartTime(ZonedDateTime joinStartTime) {
		this.joinStartTime = joinStartTime;
	}
	public ZonedDateTime getJoinEndTime() {
		return joinEndTime;
	}
	public void setJoinEndTime(ZonedDateTime joinEndTime) {
		this.joinEndTime = joinEndTime;
	}
	public String getJoinMessage() {
		return joinMessage;
	}
	public void setJoinMessage(String joinMessage) {
		this.joinMessage = joinMessage;
	}
	public Integer getJoinLimit() {
		return joinLimit;
	}
	public void setJoinLimit(Integer joinLimit) {
		this.joinLimit = joinLimit;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
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
