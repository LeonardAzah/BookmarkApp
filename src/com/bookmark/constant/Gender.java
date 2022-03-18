package com.bookmark.constant;

public enum Gender {
	
	 MALE ( 0),
	 FEMALE ( 1),
	TRANSGENDER ( 2);
	private Gender(int num) {
		 this.num = num;
	 }
	 
	 private int num;

	public int getNum() {
		return num;
	}

}
