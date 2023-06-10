package com.ngntuli.bookmark.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ngntuli.bookmark.models.WebLink;
import com.ngntuli.bookmark.services.BookmarkService;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: porn in url -- false
		WebLink webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For porn in url - isKidFriendlyEligible() must return false");

		// Test 2: porn in title -- false
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For porn in title - isKidFriendlyEligible() must return false");

		// Test 3: adult in host -- false
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaadult.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For adult in host - isKidFriendlyEligible() must return false");

		// Test 4: adult in url, but not in host part -- false
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaadult.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For adult in url - isKidFriendlyEligible() must return false");

		// Test 5: adult in title only -- false
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2 adult",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "For adult in title - isKidFriendlyEligible() must return false");
	}

}
