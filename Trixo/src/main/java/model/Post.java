package model;

import java.util.List;

public class Post {
	private String id;
	private String caption;
	private List<String> images;
	private String createdAt;
	private int likesCount;
	private int commentsCount;
	private List<String> tags;
	private User user;
	private Report report;
	private boolean isLiked;
	
	public Post() {}
	
	public Post(String id, String caption, List<String> images, String createdAt, int likesCount, int commentsCount,
			List<String> tags, User user, Report report, boolean isLiked) {
		this.id = id;
		this.caption = caption;
		this.images = images;
		this.createdAt = createdAt;
		this.likesCount = likesCount;
		this.commentsCount = commentsCount;
		this.tags = tags;
		this.user = user;
		this.report = report;
		this.isLiked = isLiked;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public List<String> getImages() {
		return images;
	}
	
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public int getLikesCount() {
		return likesCount;
	}
	
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	
	public int getCommentsCount() {
		return commentsCount;
	}
	
	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isLiked() {
		return isLiked;
	}
	
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	
	public Report getReport() {
		return report;
	}
	
	public void setReport(Report report) {
		this.report = report;
	}
}
