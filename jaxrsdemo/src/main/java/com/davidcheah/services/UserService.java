package com.davidcheah.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.davidcheah.model.User;

public class UserService {
	private static List<User> users = new ArrayList<User>();

	private static int usersCount = 0;
	static {
		users.add(new User(++usersCount, "Tony Stark", "ironman@avengers.inc"));
		users.add(new User(++usersCount, "Steve Rogers", "captain@avengers.inc"));
		users.add(new User(++usersCount, "Bruce Banner", "hulk@avengers.inc"));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User add(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	public User delete(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

	public User update(int id, User updatedUser) {
		for (User user : users) {
			if (user.getId() == id) {
				user.setName(updatedUser.getName());
				user.setEmail(updatedUser.getEmail());
				return user;
			}
		}
		return null;
	}
}
