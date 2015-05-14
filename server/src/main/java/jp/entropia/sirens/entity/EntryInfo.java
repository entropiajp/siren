package jp.entropia.sirens.entity;

import org.seasar.doma.Entity;

@Entity
public class EntryInfo {

	private String roleName;
	
	private String tuneName;
	
	private String eventName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getTuneName() {
		return tuneName;
	}

	public void setTuneName(String tuneName) {
		this.tuneName = tuneName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
