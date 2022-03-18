package com.bookmark;

import java.util.List;

import com.bookmark.ontoller.BookmarkContoller;

public class View {
	

	
		public static void browse(User user, List<List<BookMark>> bookmarks) {
			System.out.println("\n"+ user.getEmail()+ " is browsing items..");
			int bookMarkCount =0;
			for(List<BookMark>bookmarkList: bookmarks) {
				for(BookMark bookmark: bookmarkList) {
					
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if(isBookmarked) {
						bookMarkCount++;
						BookmarkContoller.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New item bookmarked .."+bookmark);
					
						
					}
				}
			}
			
		}

		private static boolean getBookmarkDecision(BookMark bookmark) {
			
			return Math.random() < 0.5 ? true: false;
		}
	}


