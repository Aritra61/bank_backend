package com.microcredential.bankmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.microcredential.bankmanagement.entity.User;
import com.microcredential.bankmanagement.repository.UserRepository;
import com.microcredential.bankmanagement.utility.Userutils;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTests {

	@InjectMocks
	private UserService userservice;
	
	@Mock
	private UserRepository userrepo;
	
	@Mock
	private User user;
	
	@Mock
	private Userutils userutils;
	
	@Test
	public void saveUserTest () {
		Mockito.when(userrepo.save(Mockito.any())).thenReturn(new User(
				"ari", "aritra",  "R-005", "password", "email", "address",
				"male", "M", "contactNumber", "accountType", "dateOfBirth",
				"accountnumber", "gurdianName", "gurdianType", "country"," state",
				"citizenShip", "citizenStatus", "dateOfRegistration", "bankName", "branchName",
				"idproofType", "iddocNumber", "refaccholderName", "refaccholderAccNo",
				" refaccholderAddress"));
		User lo = new User();
		lo.setCountry("India");
		User mockeduser = userservice.saveuser(lo);
		assertEquals("R-005",mockeduser.getCustomerId());		
	}
	
	@Test
	public void getUserbyIdTest() {
		String id="abc";
		Mockito.when(userrepo.findById(Mockito.any())).thenReturn(Optional.of(
				new User("ari", "aritra",  "R-005", "password", "email", "address",
				"male", "M", "contactNumber", "accountType", "dateOfBirth",
				"accountnumber", "gurdianName", "gurdianType", "country"," state",
				"citizenShip", "citizenStatus", "dateOfRegistration", "bankName", "branchName",
				"idproofType", "iddocNumber", "refaccholderName", "refaccholderAccNo",
				" refaccholderAddress")));
		assertEquals(true,userservice.getUserbyId(id).isPresent());
	}
	
	@Test
	public void updateUserTest() {
		assertEquals(user,userservice.updateUser(user));
	}
}
