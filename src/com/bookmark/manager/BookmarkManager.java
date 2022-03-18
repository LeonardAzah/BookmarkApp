package com.bookmark.manager;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.bookmark.Book;
import com.bookmark.BookMark;
import com.bookmark.Movie;
import com.bookmark.USerBookmark;
import com.bookmark.User;
import com.bookmark.WebLink;
import com.bookmark.constant.BookGenre;
import com.bookmark.constant.MovieGenre;
import com.bookmark.dao.BookmarkDao;
import com.bookmark.util.HttpConnecct;
import com.bookmark.util.IOUtil;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	public Movie createMovie(long id, String title, String string, int releaseYear, String[] cast, String[] directors, MovieGenre classics, double movieRating ) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(classics);
		movie.setMovieRating(movieRating);
		return movie;
	}
	public Book creatBook(long id, String title,  int publicationYear, String publisher, String[] authors, BookGenre genre, double bookRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPubliationYear(publicationYear);
		book.setPublishers(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(bookRating);
		return book;
	}
	
	public WebLink creatWebLink(long id, String title, String Url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(Url);
		weblink.setHost(host);
		return weblink;
	}
	public static List<List<BookMark>> getBookmarks(){
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, BookMark bookmark) {
		USerBookmark userBookmark = new USerBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userBookmark);
	}

}
