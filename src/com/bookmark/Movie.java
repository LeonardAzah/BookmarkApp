package com.bookmark;

import java.util.Arrays;

import com.bookmark.constant.MovieGenre;

public class Movie extends BookMark {
	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private MovieGenre genre;
	private double movieRating;
	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the cast
	 */
	public String[] getCast() {
		return cast;
	}
	/**
	 * @param cast the cast to set
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	/**
	 * @return the directors
	 */
	public String[] getDirectors() {
		return directors;
	}
	/**
	 * @param directors the directors to set
	 */
	public void setDirectors(String[] directors) {
		this.directors = directors;
	}
	/**
	 * @return the genre
	 */
	public MovieGenre getGenre() {
		return genre;
	}
	/**
	 * @param classics the genre to set
	 */
	public void setGenre(MovieGenre classics) {
		this.genre = classics;
	}
	/**
	 * @return the movieRating
	 */
	public double getMovieRating() {
		return movieRating;
	}
	/**
	 * @param movieRating the movieRating to set
	 */
	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}
	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
				+ Arrays.toString(directors) + ", genre=" + genre + ", movieRating=" + movieRating + "]";
	}
	
	

}
