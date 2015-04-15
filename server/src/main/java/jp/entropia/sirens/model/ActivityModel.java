package jp.entropia.sirens.model;

public class ActivityModel {

	private String imageUrl;
	private String username;
	private String message;
	
	public ActivityModel(String imageUrl, String username, String message) {
		super();
		this.imageUrl = imageUrl;
		this.username = username;
		this.message = message;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
