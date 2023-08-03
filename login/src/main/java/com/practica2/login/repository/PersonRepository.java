package com.practica2.login.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica2.login.entity.Person;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Serializable>{
	public Person findByUsernameAndPassword(String usern, String pass); 
}
