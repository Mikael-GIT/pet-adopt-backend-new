package com.tcc.petadopt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.petadopt.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
     
}