package com.ngntuli.bookmark.dao;

import com.ngntuli.bookmark.DataStore;
import com.ngntuli.bookmark.entities.Bookmark;
import com.ngntuli.bookmark.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);

	}
}
