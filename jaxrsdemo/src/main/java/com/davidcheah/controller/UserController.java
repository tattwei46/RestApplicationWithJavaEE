package com.davidcheah.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.davidcheah.model.User;
import com.davidcheah.services.UserService;

@Path("/service")
public class UserController {

	private UserService service = new UserService();

	//http://localhost:8080/jaxrsdemo/rest/service/users
	@GET
	@Path("/users")
	public List<User> getUsers() {
		List<User> users = service.retrieveUsers();
		return users;
	}
}