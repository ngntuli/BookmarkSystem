package com.ngntuli.bookmark;

import com.ngntuli.bookmark.entities.Bookmark;
import com.ngntuli.bookmark.entities.User;
import com.ngntuli.bookmark.services.BookmarkService;
import com.ngntuli.bookmark.services.UserService;

public class App {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("-".repeat(26));
		System.out.println("1. Loading data ...");
		System.out.println("-".repeat(26));
		DataStore.loadData();

		users = UserService.getInstance().getUsers();
		bookmarks = BookmarkService.getInstance().getBookmarks();

		System.out.println("Printing data ...");
		printUserData();
		printBookmarkData();
		System.out.println("-".repeat(166));
	}

	private static void printUserData() {
		System.out.println("-".repeat(166));
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarksList : bookmarks) {
			System.out.println("-".repeat(166));
			for (Bookmark bookmark : bookmarksList) {
				System.out.println(bookmark);
			}
		}
	}

	private static void startBookmarking() {
		System.out.println("-".repeat(166));
		System.out.println("2. Bookmarking ...");
		for (User user : users) {
			View.bookmark(user, bookmarks);
		}

	}

	public static void main(String[] args) {
		loadData();
		startBookmarking();
	}

}
