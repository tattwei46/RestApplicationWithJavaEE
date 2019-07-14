package com.davidcheah.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.davidcheah.model.User;
import com.davidcheah.services.UserService;

@Path("/service")
public class UserController {

	private UserService service = new UserService();

	// http://localhost:8080/jaxrsdemo/service/users
	@GET
	@Path("/users")
	public List<User> getUsers() {
		List<User> users = service.getAllUsers();
		if (users.size() > 0)
			return users;
		throw new WebApplicationException(Response.Status.NOT_FOUND);
	}

	@GET
	@Path("/users/{id}")
	public User getUser(@PathParam("id") int id) {
		User user = service.getUser(id);
		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return user;
	}

	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		User newUser = service.add(user);
		if (newUser == null) {
			throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
		}
		String message = "User id " + newUser.getId() + " created.";
		return Response
			      .status(Response.Status.CREATED)
			      .entity(message)
			      .build();
	}

	@DELETE
	@Path("/users/{id}")
	public Response deleteUser(@PathParam("id") int id) {
		User removedUser = service.delete(id);
		if (removedUser == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		String message = "User id " + removedUser.getId() + " removed.";
		return Response
			      .status(Response.Status.OK)
			      .entity(message)
			      .build();
	}
	
	@PUT
	@Path("/users/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, User user) {
		System.out.println("update received");
		User updateUser = service.update(id, user);
		if (updateUser == null) {
			throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
		}
		String message = "User id " + updateUser.getId() + " updated.";
		return Response
			      .status(Response.Status.CREATED)
			      .entity(message)
			      .build();
	}
}