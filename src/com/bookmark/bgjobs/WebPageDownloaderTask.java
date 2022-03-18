package com.bookmark.bgjobs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.bookmark.BookMark;
import com.bookmark.dao.*;


public class WebPageDownloaderTask implements Runnable {
	
	private static BookMark dao = new BookmarkDao();
	private static final long TIME_FRAME = 3000000000L;
	private boolean  downloadAll = false;
	
	ExecutorService downloaderExecutor = Executors.newFixedThreadPool(5);
	
	
	public WebPageDownloaderTask(boolean downloadAll) {
		this.downloadAll = downloadAll;
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			
		}
		
	}

	

}
