package com.ngntuli.bookmark.controllers;

import com.ngntuli.bookmark.models.Bookmark;
import com.ngntuli.bookmark.models.User;
import com.ngntuli.bookmark.services.BookmarkService;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkService.getInstance().saveUserBoomark(user, bookmark);

	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkService.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

	}

}
