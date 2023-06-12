package com.ngntuli.bookmark.models;

import java.util.Arrays;

import com.ngntuli.bookmark.services.Shareable;
import com.ngntuli.bookmark.utilities.BookGenre;

public class Book extends Bookmark implements Shareable {
	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amozonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public String getGenre() {
		return genre;
	}

	public double getAmozonRating() {
		return amozonRating;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setAmozonRating(double amozonRating) {
		this.amozonRating = amozonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amozonRating=" + amozonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<authors>").append(String.join(",", authors)).append("</authors>");
		builder.append("<publisher>").append(publisher).append("</publisher>");
		builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<amozonRating>").append(amozonRating).append("</amozonRating>");
		builder.append("</item>");

		return builder.toString();
	}
}
