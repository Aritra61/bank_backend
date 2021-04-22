package com.microcredential.bankmanagement.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.microcredential.bankmanagement.entity.User;
import com.microcredential.bankmanagement.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User newuser) {
		log.info("Inside saveuser method");
		User user = userservice.saveuser(newuser);
		log.info("New user is saved : {}",user);
		return user;
	}

	@GetMapping("/getuser/{userid}")
	public Optional<User> getUserbyId(@PathVariable String userid) {
		log.info("Inside getuserbyid method");
		Optional<User> user = userservice.getUserbyId(userid);
		if (user.isPresent()) {
			log.info("The user is retrived {}",user);
		} else {
			log.info("The user is not present {}",user);
		}
		return user;
	}
	
	@GetMapping("/loginuser/{userid}")
	public Optional<User> loginuserbyId(@PathVariable String userid) {
		log.info("Inside getuserbyid method");
		Optional<User> user = userservice.loginUserbyId(userid);
		if (user.isPresent()) {
			log.info("The user is retrived : {}",user);
		} else {
			log.info("The user is not present: {}",user);
		}
		return user;
	}

	@PostMapping("/updateuser")
	public User upadteUser(@RequestBody User newuser) {
		log.info("Inside updateuser method");
		User updateduser = userservice.updateUser(newuser);
		log.info("The user is updated : {}",updateduser);
		return updateduser;
	}
}
