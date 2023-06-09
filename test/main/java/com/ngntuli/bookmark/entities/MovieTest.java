package com.ngntuli.bookmark.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ngntuli.bookmark.constants.MovieGenre;
import com.ngntuli.bookmark.services.BookmarkService;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: Horror Genre -- false
		Movie movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);

		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For Horror Genre - isKidFriendlyEligible must return false");

		// Test 2: Thriller Genre -- false
		movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For Thriller Genre - isKidFriendlyEligible must return false");
	}

}
