package com.microcredential.bankmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loan {

	private String loanType;
	private String loanAmount;
	private String rateOfInterest;
	private String loanDuration;
	private String loanIssueDate;
	private String annualIncome;
	private String companyName;
	private String courseName;
	private String courseFee;
	private String fatherName;
	@Id
	private String loanId;
	private String customerId;
	
	public Loan() {
		
	}
	
	public Loan(String loanType, String loanAmount, String rateOfInterest, String loanDuration, String loanIssueDate,
			String annualIncome, String companyName, String courseName, String courseFee, String fatherName,
			String loanId, String customerId) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.rateOfInterest = rateOfInterest;
		this.loanDuration = loanDuration;
		this.loanIssueDate = loanIssueDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.fatherName = fatherName;
		this.loanId = loanId;
		this.customerId = customerId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(String loanDuration) {
		this.loanDuration = loanDuration;
	}
	public String getLoanIssueDate() {
		return loanIssueDate;
	}
	public void setLoanIssueDate(String loanIssueDate) {
		this.loanIssueDate = loanIssueDate;
	}
	public String getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(String courseFee) {
		this.courseFee = courseFee;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Loan [loanType=" + loanType + ", loanAmount=" + loanAmount + ", rateOfInterest=" + rateOfInterest
				+ ", loanDuration=" + loanDuration + ", loanIssueDate=" + loanIssueDate + ", annualIncome="
				+ annualIncome + ", companyName=" + companyName + ", courseName=" + courseName + ", courseFee="
				+ courseFee + ", fatherName=" + fatherName + ", loanId=" + loanId + ", customerId=" + customerId + "]";
	}
	
	
	
	
}
