package com.ngntuli.bookmark.models;

import java.util.Arrays;

import com.ngntuli.bookmark.utilities.MovieGenre;

public class Movie extends Bookmark {
	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private MovieGenre genre;
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

	public MovieGenre getGenre() {
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

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
				+ Arrays.toString(directors) + ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if (genre.equals(MovieGenre.HORROR) || genre.equals(MovieGenre.THRILLERS)) {
			return false;
		}
		return true;
	}

}
