package com.microcredential.bankmanagement.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microcredential.bankmanagement.entity.Loan;
import com.microcredential.bankmanagement.repository.LoanRepository;
import com.microcredential.bankmanagement.utility.Loanutils;

@Service
public class LoanService {
	
	private static final Logger log = LoggerFactory.getLogger(LoanService.class);
	
	@Autowired
	LoanRepository loanrepo;
	
	@Autowired
	Loanutils loanutils;

	public Loan saveLoan(Loan newloan) {
		log.info("Inside saveloan method of Loanservice");
		List<Loan> loanlist = loanrepo.findAll();
		String loanid = loanutils.createloanid(loanlist,newloan);
		newloan.setLoanId(loanid);
	    Loan loan = loanrepo.save(newloan);
	    log.info("New loan has been saved : {}",loan);
	    return loan;
	}
	
	public List<Loan> getLoanbyId(String id) {
		log.info("Inside getLoanbyId method of Loanservice");
		List<Loan> loanlist = loanrepo.findAll();
		List<Loan> foundloanlist = loanutils.findloanbyid(loanlist,id);
		log.info("Loanlist has been found : {}",foundloanlist);
		return foundloanlist;
	}
}
