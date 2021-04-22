package com.microcredential.bankmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.microcredential.bankmanagement.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;
	
	private static final Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		log.info("Inside loadUserByUsername method and the username is : {} ",username);
		
		List<com.microcredential.bankmanagement.entity.User> userlist = userRepo.findAll();
		for (com.microcredential.bankmanagement.entity.User user : userlist) {
			if (user.getCustomerId().equalsIgnoreCase(username)) {
				String pwhash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
				log.info("Becrypted password is : {}",pwhash);
				return new User(username, pwhash,
						new ArrayList<>());
			}
		}
		throw new UsernameNotFoundException("User not found with username: " + username);	
	}
}
