package com.ngntuli.bookmark.services;

import com.ngntuli.bookmark.dao.BookmarkDao;
import com.ngntuli.bookmark.entities.Book;
import com.ngntuli.bookmark.entities.Bookmark;
import com.ngntuli.bookmark.entities.Movie;
import com.ngntuli.bookmark.entities.User;
import com.ngntuli.bookmark.entities.UserBookmark;
import com.ngntuli.bookmark.entities.WebLink;

public class BookmarkService {
	private static BookmarkService instance = new BookmarkService();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkService() {
	}

	public static BookmarkService getInstance() {
		return instance;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
			double amozonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmozonRating(amozonRating);

		return book;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBoomark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		dao.saveUserBookmark(userBookmark);

	}
}
