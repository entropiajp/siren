package jp.entropia.sirens.model;

import java.time.ZonedDateTime;

public class EventModel {

	private Integer id;
	private String name;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private String place;
	private String imageUrl;
	private ZonedDateTime voteStartTime;
	private ZonedDateTime voteEndTime;
	private String description;
	private String voteMessage;
	private Integer voteLimit;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
