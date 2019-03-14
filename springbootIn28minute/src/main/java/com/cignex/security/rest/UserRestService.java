package com.cignex.security.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cignex.security.dao.UserDaoServices;
import com.cignex.security.exception.UserNotFoundException;
import com.cignex.security.model.User;

@RestController
@RequestMapping("/user")
public class UserRestService {

	@Autowired
	UserDaoServices dao;

	User user;

	@GetMapping("/all")
	protected List<User> getAllUser() {
		return dao.getAllusers();
	}

	@GetMapping("/{id}")
	private Resource<User> getUserById(@PathVariable int id) {
		user = dao.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id : " + id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(link.withRel("All-Users"));
		return resource;
	}

	@PostMapping("/add")
	private ResponseEntity<Object> addUser(@Valid @RequestBody User user, BindingResult result) {
		this.user = dao.addUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	private String deleteUserById(@PathVariable int id) {
		user = dao.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("id : " + id);
		}

		return "Delete Sucessfully : " + user;
	}

}
