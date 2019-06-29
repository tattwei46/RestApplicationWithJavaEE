package com.davidcheah.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.davidcheah.model.User;
import com.davidcheah.services.UserService;

@Path("/service")
public class UserController {

	private UserService service = new UserService();

	//http://localhost:8080/jaxrsdemo/service/users
	@GET
	@Path("/users")
	public List<User> getUsers() {
		List<User> users = service.getAllUsers();
		return users;
	}
	
	@GET
	@Path("/users/{id}")
	public User getUser(@PathParam("id") int id) {
		User user = service.getUser(id);
		return user;
	}
	
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		User newUser= service.add(user);
		return newUser;
	}
}