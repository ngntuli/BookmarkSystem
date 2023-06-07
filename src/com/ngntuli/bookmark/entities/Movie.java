package com.ngntuli.bookmark.entities;

public class Movie extends Bookmark {
	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private String genre;
	private double imdbRating;

	public int getReleaseYear() {
		return releaseYear;
	}

	public String[] getCast() {
		return cast;
	}

	public String[] getDirectors() {
		return directors;
	}

	public String getGenre() {
		return genre;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

}
