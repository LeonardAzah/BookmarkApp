package com.bookmark;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bookmark.constant.BookGenre;
import com.bookmark.constant.Gender;
import com.bookmark.constant.MovieGenre;
import com.bookmark.constant.UserType;
import com.bookmark.manager.BookmarkManager;
import com.bookmark.manager.UserManager;

public class DataStore {
	
	private static List<User> users = new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}
	
	
	

	private static List<List<BookMark>> bookmarks = new ArrayList<>();
	public static List<List<BookMark>> getBookmarks() {
		return bookmarks;
	}


	private static List<USerBookmark> userBookmarks = new ArrayList<>();

	public static void loadData() throws ClassNotFoundException {
		
		
		try {
			;
			Class.forName("new com.mysql.jdbc.Driver()");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://loalhost:3306/bookmarkapp?useSSL=false", "root", "lamar");
				Statement stmt = conn.createStatement();){
			loadUsers(stmt);
			loadWebLinks(stmt);
			loadMovies(stmt);
			loadBooks(stmt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadUsers(Statement stmt) throws SQLException {
		String query = "Select * From User";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			long id = rs.getLong("id");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			int gendre_id = rs.getInt("gendre_id");
			Gender gender = Gender.values()[gendre_id];
			int user_type_id = rs.getInt("user_type_id");
			UserType userType = UserType.values()[user_type_id];
			
			User user = UserManager.getInstance().creatUser(id, email, password, firstName, lastName, gender, userType);
			users.add(user);
		}
		
		
	}

	private static void loadWebLinks(Statement stmt) throws SQLException {
		String query="Select * From Weblink";
		ResultSet rs = stmt.executeQuery(query);
		List<BookMark> bookmarklist = new ArrayList<>();
		while(rs.next()) {
			long id = rs.getLong("id");
			String title = rs.getString("title");
			String url = rs.getString("url");
			String host = rs.getString("host");
			
			BookMark bookmark = BookmarkManager.getInstance().creatWebLink(id, title, url, host);
			bookmarklist.add(bookmark);
			
		}
		bookmarks.add(bookmarklist);
		
	}

	private static void loadMovies(Statement stmt) throws SQLException {
		String query = "Select m.id, title, release_year, GROUP_CONCAT(DISTINCT a.name SEPARATOR ',') AS cast, GROUP_CONCAT(DISTINCT d.name SEPARATOR ',') AS directors, movie_genre_id, imdb_rating"
				+ " from Movie m, Actor a, Movie_Actor ma, Director d, Movie_Director md "
				+ "where m.id = ma.movie_id and ma.actor_id = a.id and "
				      + "m.id = md.movie_id and md.director_id = d.id group by m.id";
		ResultSet rs = stmt.executeQuery(query);
		
		List<BookMark> bookmarklist = new ArrayList<>();
		
		while(rs.next()) {
			long id = rs.getLong("id");
			String title = rs.getString("title");
			int releaseYear = rs.getInt("release_year");
			String[] cast = rs.getString("cast").split(",");
			String[] directors = rs.getString("directors").split(",");			
			int genre_id = rs.getInt("movie_genre_id");
			MovieGenre genre = MovieGenre.values()[genre_id];
			double imdbRating = rs.getDouble("imdb_rating");
			
			BookMark bookmark = BookmarkManager.getInstance().createMovie(id, title, "", releaseYear, cast, directors, genre, imdbRating/*, values[7]*/);
    		bookmarklist.add(bookmark);
		}
		bookmarks.add(bookmarklist);
		
	}
	

	private static void loadBooks(Statement stmt) throws SQLException {
		String query = "Select b.id, title, publication_year, p.name, GROUP_CONCAT(a.name SEPARATOR ',') AS authors, book_genre_id, amazon_rating, created_date"
				+ " from Book b, Publisher p, Author a, Book_Author ba "
				+ "where b.publisher_id = p.id and b.id = ba.book_id and ba.author_id = a.id group by b.id";
    	ResultSet rs = stmt.executeQuery(query);
		List<BookMark> bookmarklist = new ArrayList<>();

		while(rs.next()) {
			
			Long id = rs.getLong("id");
			String title = rs.getString("title");
			int publication_year = rs.getInt("publication_year");
			String publisher = rs.getString("publisher");
			String[] authors = rs.getString("authors").split(",");
			int genre_id = rs.getInt("book_genre_id");
			BookGenre genre = BookGenre.values()[genre_id];
			double amazonRating = rs.getDouble("amazon_rating");
			
			Date createdDate = rs.getDate("created_date");
			System.out.println("createdDate"+createdDate);
			Timestamp timeStamp = rs.getTimestamp(8);
			System.out.println("LoalDateTime "+timeStamp.toLocalDateTime());
			
			System.out.println("id: " + id + ", title: " + title + ", publication year: " + publication_year + ", publisher: " + publisher + ", authors: " + String.join(", ", authors) + ", genre: " + genre + ", amazonRating: " + amazonRating);
			BookMark bookmark = BookmarkManager.getInstance().creatBook(id, title, publication_year, publisher, authors, genre, amazonRating);
			bookmarklist.add(bookmark);
			
		}
		bookmarks.add(bookmarklist);
		
	}

	
	public static void add(USerBookmark userBookmark) {
		
		userBookmarks.add(userBookmark);
		
	}

}
