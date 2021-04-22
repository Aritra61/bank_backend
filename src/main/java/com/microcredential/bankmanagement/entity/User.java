package com.microcredential.bankmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	private String name ;
	private String username;
	@Id
	private String customerId ;
	private String password;
	private String email;
	private String address;
	private String gender;
	private String maritalStatus;
	private String contactNumber;
	private String accountType;
	private String dateOfBirth;
	private String accountnumber;
	private String gurdianName;
	private String gurdianType;
	private String country;
	private String state;
	private String citizenShip;
	private String citizenStatus;
	private String dateOfRegistration;
	private String bankName;
	private String branchName;
	private String idproofType;
	private String iddocNumber;
	private String refaccholderName;
	private String refaccholderAccNo;
	private String refaccholderAddress;
	
	public User() {
		
	}

	public User(String name, String username, String customerId, String password, String email, String address,
			String gender, String maritalStatus, String contactNumber, String accountType, String dateOfBirth,
			String accountnumber, String gurdianName, String gurdianType, String country, String state,
			String citizenShip, String citizenStatus, String dateOfRegistration, String bankName, String branchName,
			String idproofType, String iddocNumber, String refaccholderName, String refaccholderAccNo,
			String refaccholderAddress) {
		super();
		this.name = name;
		this.username = username;
		this.customerId = customerId;
		this.password = password;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.contactNumber = contactNumber;
		this.accountType = accountType;
		this.dateOfBirth = dateOfBirth;
		this.accountnumber = accountnumber;
		this.gurdianName = gurdianName;
		this.gurdianType = gurdianType;
		this.country = country;
		this.state = state;
		this.citizenShip = citizenShip;
		this.citizenStatus = citizenStatus;
		this.dateOfRegistration = dateOfRegistration;
		this.bankName = bankName;
		this.branchName = branchName;
		this.idproofType = idproofType;
		this.iddocNumber = iddocNumber;
		this.refaccholderName = refaccholderName;
		this.refaccholderAccNo = refaccholderAccNo;
		this.refaccholderAddress = refaccholderAddress;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getCustomerId() {
		return customerId;
	}




	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getMaritalStatus() {
		return maritalStatus;
	}




	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}




	public String getContactNumber() {
		return contactNumber;
	}




	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}




	public String getAccountType() {
		return accountType;
	}




	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}




	public String getDateOfBirth() {
		return dateOfBirth;
	}




	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}




	public String getAccountnumber() {
		return accountnumber;
	}




	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}




	public String getGurdianName() {
		return gurdianName;
	}




	public void setGurdianName(String gurdianName) {
		this.gurdianName = gurdianName;
	}




	public String getGurdianType() {
		return gurdianType;
	}




	public void setGurdianType(String gurdianType) {
		this.gurdianType = gurdianType;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getCitizenShip() {
		return citizenShip;
	}




	public void setCitizenShip(String citizenShip) {
		this.citizenShip = citizenShip;
	}




	public String getCitizenStatus() {
		return citizenStatus;
	}




	public void setCitizenStatus(String citizenStatus) {
		this.citizenStatus = citizenStatus;
	}




	public String getDateOfRegistration() {
		return dateOfRegistration;
	}




	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}




	public String getBankName() {
		return bankName;
	}




	public void setBankName(String bankName) {
		this.bankName = bankName;
	}




	public String getBranchName() {
		return branchName;
	}




	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}




	public String getIdproofType() {
		return idproofType;
	}




	public void setIdproofType(String idproofType) {
		this.idproofType = idproofType;
	}




	public String getIddocNumber() {
		return iddocNumber;
	}




	public void setIddocNumber(String iddocNumber) {
		this.iddocNumber = iddocNumber;
	}




	public String getRefaccholderName() {
		return refaccholderName;
	}




	public void setRefaccholderName(String refaccholderName) {
		this.refaccholderName = refaccholderName;
	}




	public String getRefaccholderAccNo() {
		return refaccholderAccNo;
	}




	public void setRefaccholderAccNo(String refaccholderAccNo) {
		this.refaccholderAccNo = refaccholderAccNo;
	}




	public String getRefaccholderAddress() {
		return refaccholderAddress;
	}




	public void setRefaccholderAddress(String refaccholderAddress) {
		this.refaccholderAddress = refaccholderAddress;
	}




	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", customerId=" + customerId + ", password=" + password
				+ ", email=" + email + ", address=" + address + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", contactNumber=" + contactNumber + ", accountType=" + accountType + ", dateOfBirth="
				+ dateOfBirth + ", accountnumber=" + accountnumber + ", gurdianName=" + gurdianName + ", gurdianType="
				+ gurdianType + ", country=" + country + ", State=" + state + ", citizenShip=" + citizenShip
				+ ", citizenStatus=" + citizenStatus + ", dateOfRegistration=" + dateOfRegistration + ", bankName="
				+ bankName + ", branchName=" + branchName + ", idproofType=" + idproofType + ", iddocNumber="
				+ iddocNumber + ", refaccholderName=" + refaccholderName + ", refaccholderAccNo=" + refaccholderAccNo
				+ ", refaccholderAddress=" + refaccholderAddress + "]";
	}

	
	
	
}
