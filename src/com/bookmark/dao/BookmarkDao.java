package com.bookmark.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookmark.Book;
import com.bookmark.BookMark;
import com.bookmark.DataStore;
import com.bookmark.Movie;
import com.bookmark.USerBookmark;
import com.bookmark.WebLink;
import com.bookmark.WebLink.DownloadStatus;
import com.bookmark.manager.BookmarkManager;

public class BookmarkDao extends BookMark {
	public List<List<BookMark>> getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(USerBookmark userBookmark) {
		//DataStore.add(userBookmark);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://loalhost:3306/bookmarkapp?useSSL=false", "root", "lamar");
				Statement stmt = conn.createStatement();){
			if(userBookmark.getBookmark() instanceof Book) {
				saveUserBook(userBookmark, stmt);
			} else if(userBookmark.getBookmark() instanceof Movie) {
				saveUserMovie(userBookmark, stmt);
				
			} else  {
				saveUserWeblink(userBookmark, stmt);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private void saveUserWeblink(USerBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert INTO User_Weblink (user_id, weblink_id) values("
				+userBookmark.getUser().getId()+", "+userBookmark.getBookmark().getId()+")";
			stmt.executeUpdate(query);
		
	}

	private void saveUserMovie(USerBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert INTO User_Movie (user_id, movie_id) values("
				+userBookmark.getUser().getId()+", "+userBookmark.getBookmark().getId()+")";
			stmt.executeUpdate(query);
		
	}

	private void saveUserBook(USerBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert INTO User_Book (user_id, book_id) values("
			+userBookmark.getUser().getId()+", "+userBookmark.getBookmark().getId()+")";
		stmt.executeUpdate(query);
		
	}
	/*
	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<WebLink> getAllWeblinks(){
		List<WebLink> result = new ArrayList<>();
		List<List<BookMark>> bookmark = DataStore.getBookmarks();
		List<BookMark> allWeblinks = bookmark.get(0);
		
		for(BookMark bookmark1: allWeblinks) {
			result.add(WebLink)bookmark1);
			
			
			
		}
		
		
		return result;
	}
	
	public List<WebLink> getWeblinks(DownloadStatus downloadstatus){
		List<WebLink> result = new ArrayList<>();
		List<WebLink> allWeblinks = getAllWeblinks();
		for(Weblink weblink: allWeblinks) {
			if(weblink.getDownloadStatus().equals(downloadstatus)) {
				result.add(weblink);
			}
		}
		
		
		return result;
	}

	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		return false;
	}
	*/

	
}
