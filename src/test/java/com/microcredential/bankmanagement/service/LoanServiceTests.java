package com.microcredential.bankmanagement.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
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

import com.microcredential.bankmanagement.entity.Loan;
import com.microcredential.bankmanagement.entity.User;
import com.microcredential.bankmanagement.repository.LoanRepository;
import com.microcredential.bankmanagement.repository.UserRepository;
import com.microcredential.bankmanagement.utility.Loanutils;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LoanServiceTests {
	
	@InjectMocks
	private LoanService loanservice;
	
	@Mock
	private LoanRepository loanrepo;
	
	@Mock
	private Loanutils loanutils;
	
	@Mock
	private Loan loan;
		
	 @Test
	public void saveLoanTest() {
		Mockito.when(loanrepo.save(Mockito.any())).thenReturn(new Loan(
				"personal","2000","20","15","10-10-2020","3000","cts"
				,null,null,null
				,"LP-001","R-001"));
		Loan loan = new Loan();
		Loan newloan = loanservice.saveLoan(loan);
		assertEquals("LP-001",newloan.getLoanId());
	}

	@Test
	public void getLoanbyIdTest() {
		Loan loan1 = new Loan();
		Loan loan2 = new Loan();
		ArrayList<Loan> obj = new ArrayList<Loan>();
		obj.add(loan1);obj.add(loan2);
		Mockito.when(loanrepo.findAll()).thenReturn(obj);
		Mockito.when(loanutils.findloanbyid(obj,"abc")).thenReturn(obj);
		assertEquals(2,loanservice.getLoanbyId("abc").size());
	}
}
