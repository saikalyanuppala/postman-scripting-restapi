package com.optum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optum.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person findByAge(int age);
}
