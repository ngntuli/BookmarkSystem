package com.ngntuli.bookmark.models;

import com.ngntuli.bookmark.utilities.KidFriendlyStatus;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;

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

	public abstract boolean isKidFriendlyEligible();

	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}
}
