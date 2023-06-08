package com.ngntuli.bookmark.entities;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profileUrl;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

}
