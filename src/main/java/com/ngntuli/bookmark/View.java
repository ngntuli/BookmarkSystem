package com.ngntuli.bookmark;

import com.ngntuli.bookmark.constants.BookmarkData;
import com.ngntuli.bookmark.constants.KidFriendlyStatus;
import com.ngntuli.bookmark.constants.UserType;
import com.ngntuli.bookmark.controllers.BookmarkController;
import com.ngntuli.bookmark.entities.Bookmark;
import com.ngntuli.bookmark.entities.User;

public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println(user.getEmail() + " is browsing items ...");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarksList : bookmarks) {
			for (Bookmark bookmark : bookmarksList) {
				// Book marking!!
				if (bookmarkCount < BookmarkData.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked ..." + bookmark);
					}
				}
				// Mark as kid-friendly
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision();
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", " + bookmark);
						}
					}
				}
			}

		}
		System.out.println();

	}

	private static String getKidFriendlyStatusDecision() {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//		System.out.println(user.getEmail() + " is bookmarking");
//		for (int i = 0; i < BookmarkData.USER_BOOKMARK_LIMIT; i++) {
//			int typeOffset = (int) (Math.random() * BookmarkData.BOOMARK_TYPES_COUNT);
//			int bookmakOffset = (int) (Math.random() * BookmarkData.BOOKMARK_COUNT_PER_TYPE);
//
//			Bookmark bookmark = bookmarks[typeOffset][bookmakOffset];
//
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//
//			System.out.println(bookmark);
//		}
//		System.out.println();
//	}
}
