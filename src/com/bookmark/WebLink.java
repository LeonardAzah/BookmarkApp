package com.bookmark;

public class WebLink extends BookMark {
	private String url;
	private String host;
	private String htmlpage;
	
	private DownloadStatus downloadstatus = DownloadStatus.NOT_ATTEMPTED;
	
	public enum DownloadStatus{
		
		NOT_ATTEMPTED,
		SUCCESS,
		FAILED,
		NOT_ELIGIBLE;
	}
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}
	
	/*
	public boolean isKidFriendlyEligible() {
		if (url.contains("porn") || getTitle().contains("porn") || host.contains("adult")) {
			return false;
		}
		return true;
	}
	*/
	public String getHtmlpage() {
		return htmlpage;
	}
	public void setHtmlpage(String htmlpage) {
		this.htmlpage = htmlpage;
	}
	
	

}
