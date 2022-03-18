package com.bookmark;

import java.util.Arrays;

import com.bookmark.constant.BookGenre;
import com.bookmark.constant.MovieGenre;

public class Book extends BookMark {
	private int publiationYear;
	private String publishers;
	private String[] authors;
	private BookGenre genre;
	private double amazonRating;

	public int getPubliationYear() {
		return publiationYear;
	}

	public void setPubliationYear(int publiationYear) {
		this.publiationYear = publiationYear;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		
		return amazonRating;
	}

	public void setAmazonRating(double amazoneRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publiationYear=" + publiationYear + ", publishers=" + publishers + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", bookRating=" + amazonRating + "]";
	}

	

}
