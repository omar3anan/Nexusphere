package com.RestAPIs.restfulwebservice.Server.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPIs.restfulwebservice.HandleError.UserNotFoundException;
import com.RestAPIs.restfulwebservice.Server.Response;
import com.RestAPIs.restfulwebservice.Server.Entity.Post;
import com.RestAPIs.restfulwebservice.Server.Entity.User;
import com.RestAPIs.restfulwebservice.Server.Repository.PostRepository;
import com.RestAPIs.restfulwebservice.Server.Repository.UserDataRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class UserController {
	private UserDataRepository theUserService;

	// Null value

	public UserController(UserDataRepository theUserService, PostRepository thePostService) {
		super();
		this.theUserService = theUserService;

	}

	@GetMapping("/users") // Find All
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public Response getAll() {
		List<User> users = theUserService.findAll();
		return new Response("Success", "User Found", users); // return the list of users
	}

	@GetMapping("/users/{idx}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")

	public Response getUser(@PathVariable int idx) {
		Optional<User> theuser = theUserService.findById(idx);
		if (theuser.isEmpty() || idx < 0) {
			throw new UserNotFoundException("User not found " + idx);
		}
		return new Response("Success", "User Found", theuser.get()); // .get() to get the value of Optional<User>
	}

	// Allow Validation to be done
	@PostMapping("/user")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public User AddUser(@Valid @RequestBody User theUser) {
		theUser.setId(0);
		return theUserService.save(theUser);
	}

	@DeleteMapping("/users/{idx}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public Response deleteUser(@PathVariable int idx) {
		Optional<User> theUser = theUserService.findById(idx);
		if (theUser.isEmpty() || idx < 0)
			throw new UserNotFoundException("User not found " + idx);
		theUserService.deleteById(idx);
		return new Response("Success", "User id Deleted is " + idx, theUser.get());

	}

	@PutMapping("/update") // save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public User UpdateUser(@Valid @RequestBody User theUser) { // GET the Body
		return theUserService.save(theUser);
	}

}
