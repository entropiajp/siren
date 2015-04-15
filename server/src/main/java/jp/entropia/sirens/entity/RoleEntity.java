package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class RoleEntity {
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "song_id")
	private Integer songId;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "required")
	private boolean required;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "imageUrl")
	private String imageUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
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

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
