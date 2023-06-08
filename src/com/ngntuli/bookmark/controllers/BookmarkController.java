package com.ngntuli.bookmark.controllers;

import com.ngntuli.bookmark.entities.Bookmark;
import com.ngntuli.bookmark.entities.User;
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

}
