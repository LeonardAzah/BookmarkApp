package com.bookmark.launch;

import java.util.List;

import com.bookmark.BookMark;
import com.bookmark.DataStore;
import com.bookmark.User;
import com.bookmark.View;
import com.bookmark.manager.BookmarkManager;
import com.bookmark.manager.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<BookMark>> bookmarks;
	private static void loadData() throws ClassNotFoundException {
		System.out.println("1. Loading Data....");
		DataStore.loadData();
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		System.out.println("Printing Data.....");
		printUserData();
		printBookmarkData();
	}

	private static void printBookmarkData() {
		for(List<BookMark> bookmarklist: bookmarks) {
			for(BookMark bookmark: bookmarklist) {
				System.out.println(bookmark);
			}
		}
		
	}

	private static void printUserData() {
		for(User user: users) {
			System.out.println(user);
		}
	}
	private static void start() {
		//System.out.println("\n2. Bookmark......");
		for(User user: users) {
			View.browse(user, bookmarks);
		}
		
	}

	public static void main(String[] args) throws ClassNotFoundException {
		loadData();
		start();

	}

	

	

}
