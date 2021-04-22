package com.microcredential.bankmanagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.microcredential.bankmanagement.entity.Loan;
import com.microcredential.bankmanagement.service.LoanService;

@RestController
public class LoanController {
	
	private static final Logger log = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanService loanservice;

	@PostMapping("/applyloan")
	  public Loan saveUser(@RequestBody Loan newloan) {
		log.info("Inside the saveuser method");
	    Loan loan = loanservice.saveLoan(newloan);
	    log.info("New Loan is saved : {}",loan);
	    return loan;
	  }
	
	@GetMapping("/getloan/{userid}")
	public List<Loan> getUserbyId(@PathVariable String userid) {
		log.info("Inside getuserid method");
		List<Loan> foundloanlist = loanservice.getLoanbyId(userid);
		if (!foundloanlist.isEmpty()) {
			log.info("The Loanlist is retrieved : {}",foundloanlist);
		} else {
			log.info("The Loanlist is not present : {}",foundloanlist);
		}
		return foundloanlist;
	}
}
