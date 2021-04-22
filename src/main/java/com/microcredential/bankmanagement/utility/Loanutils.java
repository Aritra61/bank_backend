package com.microcredential.bankmanagement.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.microcredential.bankmanagement.entity.Loan;

@Component
public class Loanutils {

	private static final String EDUCATIONAL = "educational";
	private static final String HOUSING = "housing";
	private static final String PERSONAL = "personal";
	private static final Logger log = LoggerFactory.getLogger(Loanutils.class);
	
	public String createloanid(List<Loan> loanlist, Loan newloan) {

		log.info("Inside createloanid method");
		Set<Integer> loanpersonalidlist = new HashSet<>();
		Set<Integer> loanhousingidlist = new HashSet<>();
		Set<Integer> loaneducationidlist = new HashSet<>();

		for (Loan loan : loanlist) {
			if ((loan.getCustomerId() != null) && (loan.getLoanId() != null)) {
				String id = loan.getLoanId();
				int number = Integer.parseInt(id.substring(3));
				if (loan.getLoanType().equalsIgnoreCase(PERSONAL)) {
					loanpersonalidlist.add(number);
				}
				if (loan.getLoanType().equalsIgnoreCase(HOUSING)) {
					loanhousingidlist.add(number);
				}
				if (loan.getLoanType().equalsIgnoreCase(EDUCATIONAL)) {
					loaneducationidlist.add(number);
				}
			}
		}

		return extractLoanDetails(newloan, loanpersonalidlist, loanhousingidlist, loaneducationidlist);
	}

	private String extractLoanDetails(Loan newloan, Set<Integer> loanpersonalidlist, Set<Integer> loanhousingidlist,
			Set<Integer> loaneducationidlist) {
		if (loanpersonalidlist.isEmpty() && newloan.getLoanType().equalsIgnoreCase(PERSONAL)) {
			return "LP-001";
		}
		if (loanhousingidlist.isEmpty() && newloan.getLoanType().equalsIgnoreCase(HOUSING)) {
			return "LH-001";
		}
		if (loaneducationidlist.isEmpty() && newloan.getLoanType().equalsIgnoreCase(EDUCATIONAL)) {
			return "LE-001";
		}

		int maxid = 0;
		if (newloan.getLoanType().equalsIgnoreCase(PERSONAL)) {
			maxid = Collections.max(loanpersonalidlist);
		}
		if (newloan.getLoanType().equalsIgnoreCase(HOUSING))
			maxid = Collections.max(loanhousingidlist);
		if (newloan.getLoanType().equalsIgnoreCase(EDUCATIONAL))
			maxid = Collections.max(loaneducationidlist);

		int id = maxid + 1;
		String finalid = extractLoanType(newloan, id);
		log.info("Loan id is {} ", finalid);
		return finalid;
	}

	private String extractLoanType(Loan newloan, int id) {
		String finalid = null;
		
		if(id/10==0) {
				if(newloan.getLoanType().equalsIgnoreCase(PERSONAL)) {
					finalid= "LP-00"+Integer.toString(id);
				}
				if(newloan.getLoanType().equalsIgnoreCase(HOUSING)) {
					finalid= "LH-00"+Integer.toString(id);
				}
				if(newloan.getLoanType().equalsIgnoreCase(EDUCATIONAL)) {
					finalid= "LE-00"+Integer.toString(id);
				}
		}	
		else {
				if(newloan.getLoanType().equalsIgnoreCase(PERSONAL)) {
					finalid= "LP-0"+Integer.toString(id);
				}
				if(newloan.getLoanType().equalsIgnoreCase(HOUSING)) {
					finalid= "LH-0"+Integer.toString(id);
				}
				if(newloan.getLoanType().equalsIgnoreCase(EDUCATIONAL)) {
					finalid= "LE-0"+Integer.toString(id);
				}
		}
		return finalid;
	}

	public List<Loan> findloanbyid(List<Loan> loanlist, String userid) {
		log.info("Inside findloanbyid method");
		List<Loan> modifiedloanlist = new ArrayList<>();
		for (Loan loan : loanlist) {
			if (loan != null && loan.getCustomerId().equalsIgnoreCase(userid))
				modifiedloanlist.add(loan);
		}
		return modifiedloanlist;
	}
} 
