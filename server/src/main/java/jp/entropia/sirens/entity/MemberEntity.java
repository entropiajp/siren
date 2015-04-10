package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class MemberEntity {

	@Column(name = "id")
	private Integer id;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "displayName")
	private String displayName;
	
	@Column(name = "profileUrl")
	private String profileUrl;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@Column(name = "attend_party")
	private String attendParty;
	
	@Column(name = "admin")
	private boolean admin;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAttendParty() {
		return attendParty;
	}
	public void setAttendParty(String attendParty) {
		this.attendParty = attendParty;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
