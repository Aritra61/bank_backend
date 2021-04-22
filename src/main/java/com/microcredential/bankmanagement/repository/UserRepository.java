package com.microcredential.bankmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcredential.bankmanagement.entity.User;

public interface UserRepository extends JpaRepository<User , String> {

}
