package com.cignex.security.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cignex.security.model.User;

@Component
public class UserDaoServices {

	private static List<User> users = new ArrayList<>();

	private static int userCount = 3;
	static {
		users.add(new User(1, "Rahul", new Date()));
		users.add(new User(2, "Jalaj", new Date()));
		users.add(new User(3, "Chetan", new Date()));
	}

	public List<User> getAllusers() {
		return users;
	}

	public User findOne(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public User deleteUser(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				users.remove(u);
				return u;
			}
		}
		return null;
	}

	public User addUser(User user) {
		if (user.getId() < 0) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

}
