package com.bookmark.ontoller;

import com.bookmark.BookMark;
import com.bookmark.User;
import com.bookmark.manager.BookmarkManager;

public class BookmarkContoller {
	private static BookmarkContoller instance = new BookmarkContoller();
	private BookmarkContoller() {}
	
	public static BookmarkContoller getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, BookMark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}
	

}
