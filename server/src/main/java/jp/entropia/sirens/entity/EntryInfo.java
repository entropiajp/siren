package jp.entropia.sirens.entity;

import org.seasar.doma.Entity;

@Entity
public class EntryInfo {

	private Integer roleId;
	private String roleName;
	private Integer tuneId;
	private String tuneName;
	private Integer eventId;
	private String eventName;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getTuneId() {
		return tuneId;
	}
	public void setTuneId(Integer tuneId) {
		this.tuneId = tuneId;
	}
	public String getTuneName() {
		return tuneName;
	}
	public void setTuneName(String tuneName) {
		this.tuneName = tuneName;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
}
