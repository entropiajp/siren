package jp.entropia.sirens.model;

import java.time.ZonedDateTime;

public class MemberModel {
	
	private Integer id;
	private String userId;
	private String attendParty;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private String freeSpace;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAttendParty() {
		return attendParty;
	}
	public void setAttendParty(String attendParty) {
		this.attendParty = attendParty;
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
	public String getFreeSpace() {
		return freeSpace;
	}
	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}
	

}
