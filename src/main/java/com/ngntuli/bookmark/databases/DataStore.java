package com.ngntuli.bookmark.databases;

import com.ngntuli.bookmark.models.Bookmark;
import com.ngntuli.bookmark.models.User;
import com.ngntuli.bookmark.models.UserBookmark;
import com.ngntuli.bookmark.services.BookmarkService;
import com.ngntuli.bookmark.services.UserService;
import com.ngntuli.bookmark.utilities.BookGenre;
import com.ngntuli.bookmark.utilities.BookmarkData;
import com.ngntuli.bookmark.utilities.Gender;
import com.ngntuli.bookmark.utilities.IOUtil;
import com.ngntuli.bookmark.utilities.MovieGenre;
import com.ngntuli.bookmark.utilities.UserType;

public class DataStore {

	private static User[] users = new User[BookmarkData.TOTAL_USER_COUNT];

	public static User[] getUsers() {
		return users;
	}

	private static Bookmark[][] bookmarks = new Bookmark[BookmarkData.BOOMARK_TYPES_COUNT][BookmarkData.BOOKMARK_COUNT_PER_TYPE];

	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	private static UserBookmark[] userBookmarks = new UserBookmark[BookmarkData.TOTAL_USER_COUNT
			* BookmarkData.USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex;

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {

		String[] data = new String[BookmarkData.TOTAL_USER_COUNT];
		IOUtil.read(data, "User");
		int rowNum = 0;
		for (String row : data) {
			String[] values = row.split("\t");

			int gender = Gender.MALE;
			if (values[5].equals("f")) {
				gender = Gender.FEMALE;
			} else if (values[5].equals("t")) {
				gender = Gender.TRANSGENDER;
			}

			users[rowNum++] = UserService.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2],
					values[3], values[4], gender, values[6]);
		}
	}

	private static void loadWebLinks() {
		/*
		 * bookmarks[0][0] = BookmarkService.getInstance().createWebLink(2000,
		 * "Taming Tiger, Part 2",
		 * "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
		 * "http://www.javaworld.com"); bookmarks[0][1] =
		 * BookmarkService.getInstance().createWebLink(2001,
		 * "How do I import a pre-existing Java project into Eclipse and get up and running?"
		 * ,
		 * "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
		 * "http://www.stackoverflow.com"); bookmarks[0][2] =
		 * BookmarkService.getInstance().createWebLink(2002,
		 * "Interface vs Abstract Class",
		 * "http://mindprod.com/jgloss/interfacevsabstract.html",
		 * "http://mindprod.com"); bookmarks[0][3] =
		 * BookmarkService.getInstance().createWebLink(2003,
		 * "NIO tutorial by Greg Travis",
		 * "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf",
		 * "http://cs.brown.edu"); bookmarks[0][4] =
		 * BookmarkService.getInstance().createWebLink(2004,
		 * "Virtual Hosting and Tomcat",
		 * "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html",
		 * "http://tomcat.apache.org");
		 */
		String[] data = new String[BookmarkData.BOOKMARK_COUNT_PER_TYPE];
		IOUtil.read(data, "WebLink");
		int colNum = 0;
		for (String row : data) {
			String[] values = row.split("\t");
			bookmarks[0][colNum++] = BookmarkService.getInstance().createWebLink(Long.parseLong(values[0]), values[1],
					values[2], values[3]/* , values[4] */);
		}
	}

	private static void loadMovies() {
		bookmarks[1][0] = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
				8.5);
		bookmarks[1][1] = BookmarkService.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940,
				new String[] { "Henry Fonda", "Jane Darwell" }, new String[] { "John Ford" }, MovieGenre.CLASSICS, 8.2);
		bookmarks[1][2] = BookmarkService.getInstance().createMovie(3002, "A Touch of Greatness", "", 2004,
				new String[] { "Albert Cullum" }, new String[] { "Leslie Sullivan" }, MovieGenre.DOCUMENTARIES, 7.3);
		bookmarks[1][3] = BookmarkService.getInstance().createMovie(3003, "The Big Bang Theory", "", 2007,
				new String[] { "Kaley Cuoco", "Jim Parsons" }, new String[] { "Chuck Lorre", "Bill Prady" },
				MovieGenre.TV_SHOWS, 8.7);
		bookmarks[1][4] = BookmarkService.getInstance().createMovie(3004, "Ikiru", "", 1952,
				new String[] { "Takashi Shimura", "Minoru Chiaki" }, new String[] { "Akira Kurosawa" },
				MovieGenre.FOREIGN_MOVIES, 8.4);

	}

	private static void loadBooks() {
		bookmarks[2][0] = BookmarkService.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		bookmarks[2][1] = BookmarkService.getInstance().createBook(4001, "Self-Reliance and Other Essays", 1993,
				"Dover Publications", new String[] { "Ralph Waldo Emerson" }, BookGenre.PHILOSOPHY, 4.5);
		bookmarks[2][2] = BookmarkService.getInstance().createBook(4002, "Light From Many Lamps", 1988, "Touchstone",
				new String[] { "Lillian Eichler Watson" }, BookGenre.PHILOSOPHY, 5.0);
		bookmarks[2][3] = BookmarkService.getInstance().createBook(4003, "Head First Design Patterns", 2004,
				"O'Reilly Media", new String[] { "Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson" },
				BookGenre.TECHNICAL, 4.5);
		bookmarks[2][4] = BookmarkService.getInstance().createBook(4004, "Effective Java Programming Language Guide",
				2007, "Prentice Hall", new String[] { "Joshua Bloch" }, BookGenre.TECHNICAL, 4.9);
	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex++;

	}
}
