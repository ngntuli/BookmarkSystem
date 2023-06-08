package com.ngntuli.bookmark.entities;

import java.util.Arrays;

public class Book extends Bookmark {
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
		return true;
	}
}
