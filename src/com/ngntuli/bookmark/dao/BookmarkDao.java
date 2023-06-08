package com.ngntuli.bookmark.dao;

import com.ngntuli.bookmark.DataStore;
import com.ngntuli.bookmark.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
