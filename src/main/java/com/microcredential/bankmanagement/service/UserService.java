package com.microcredential.bankmanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microcredential.bankmanagement.entity.User;
import com.microcredential.bankmanagement.repository.UserRepository;
import com.microcredential.bankmanagement.utility.Userutils;

@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userrepo;

	@Autowired
	Userutils userutils;

	public User saveuser(User newuser) {
		log.info("Inside userservice saveuser method");
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;
		List<User> userlist = userrepo.findAll();
		String userid = userutils.createuserid(userlist);
		newuser.setCustomerId(userid);
		newuser.setAccountnumber(String.valueOf(ThreadLocalRandom.current().nextLong(smallest, biggest + 1)));
		User user = userrepo.save(newuser);
		log.info("Inside userservice, new user has been saved");
		return user;
	} 
	
	public Optional<User> getUserbyId(String id) {
		return userrepo.findById(id);
	}
	
	public Optional<User> loginUserbyId(String id) {
		return userrepo.findById(id);
	}
	
	public User updateUser(User newuser) {
		log.info("Inside updateuser method in userservice");
		List<User> userlist = userrepo.findAll();
		for (User user : userlist) {
			if (user.getCustomerId().equalsIgnoreCase(newuser.getCustomerId())) {
				userrepo.delete(user);
				userrepo.save(newuser);
			}
		}
		log.info("New user has been saved , in userservice");
		return newuser;	
	}
}
