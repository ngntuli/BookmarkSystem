package com.ngntuli.bookmark.daos;

import com.ngntuli.bookmark.config.DataStore;
import com.ngntuli.bookmark.models.Bookmark;
import com.ngntuli.bookmark.models.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);

	}
}
