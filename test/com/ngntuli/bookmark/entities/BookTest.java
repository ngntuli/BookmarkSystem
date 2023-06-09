package com.ngntuli.bookmark.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ngntuli.bookmark.constants.BookGenre;
import com.ngntuli.bookmark.services.BookmarkService;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: Philosophy Genre -- false
		Book book = BookmarkService.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);

		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For Philosophy Genre - isKidFriendlyEligible() must return false");

		// Test 2: Self help Genre -- false
		book = BookmarkService.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);

		isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For Self help Genre - isKidFriendlyEligible() must return false");
	}

}
