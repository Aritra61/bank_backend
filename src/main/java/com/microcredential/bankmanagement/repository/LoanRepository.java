package com.microcredential.bankmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcredential.bankmanagement.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan , String>{

}
