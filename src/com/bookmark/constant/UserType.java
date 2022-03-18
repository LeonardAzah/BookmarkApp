package com.bookmark.constant;

public enum UserType {
	
	
	 USER ( "user"),
	 EDITOR ( "editor"),
	 CHIEF_EDITOR ( "chiefeditor");
	
	private UserType(String type) {
		this.type = type;
		
	}
	private String type;
	public String getType() {
		return type;
	}
	
}
