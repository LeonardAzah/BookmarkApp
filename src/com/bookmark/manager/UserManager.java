package com.bookmark.manager;

import java.util.List;

import com.bookmark.DataStore;
import com.bookmark.User;
import com.bookmark.constant.Gender;
import com.bookmark.constant.UserType;
import com.bookmark.dao.UserDao;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();

	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User creatUser(long id, String email, String password, String firstname, String lastname, Gender male,
			UserType user2) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setGender(male);
		user.setUserType(user2);
		return user;

	}
	public static  List<User> getUsers() {
		return dao.getUsers();
	}

}
