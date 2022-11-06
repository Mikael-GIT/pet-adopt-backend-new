package com.tcc.petadopt.repositories;

import com.tcc.petadopt.domain.Email;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long>{

}