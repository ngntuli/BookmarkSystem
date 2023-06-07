package com.ngntuli.bookmark.entities;

public class WebLink extends Bookmark {
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public String getHost() {
		return host;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
