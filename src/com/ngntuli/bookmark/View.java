package com.ngntuli.bookmark;

import com.ngntuli.bookmark.constants.BookmarkData;
import com.ngntuli.bookmark.controllers.BookmarkController;
import com.ngntuli.bookmark.entities.Bookmark;
import com.ngntuli.bookmark.entities.User;

public class View {
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for (int i = 0; i < BookmarkData.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * BookmarkData.BOOMARK_TYPES_COUNT);
			int bookmakOffset = (int) (Math.random() * BookmarkData.BOOKMARK_COUNT_PER_TYPE);

			Bookmark bookmark = bookmarks[typeOffset][bookmakOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);

			System.out.println(bookmark);
		}
	}
}
