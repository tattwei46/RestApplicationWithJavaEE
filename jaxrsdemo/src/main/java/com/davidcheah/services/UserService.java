package com.davidcheah.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.davidcheah.model.User;

@Path("/service")
public class UserService {
	@GET
	@Path("/users")
	public List<User> getUsers() {
		
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setId("1");
		user1.setName("Ali");
		user1.setAddress("Penang");
		
		
		User user2 = new User();
		user2.setId("2");
		user2.setName("Muthu");
		user2.setAddress("KL");
		
		userList.add(user1);
		userList.add(user2);
		
		return userList;
	}
}
