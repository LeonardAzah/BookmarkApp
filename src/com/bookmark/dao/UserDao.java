package com.bookmark.dao;

import java.util.List;

import com.bookmark.DataStore;
import com.bookmark.User;

public class UserDao {
	public List<User> getUsers() {
		return DataStore.getUsers();
	}

}
