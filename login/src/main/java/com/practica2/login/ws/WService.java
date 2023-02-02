package com.practica2.login.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.practica2.login.entity.Person;
import com.practica2.login.jwt.JwtTokenInterface;
import com.practica2.login.repository.PersonRepository;
import com.practica2.login.serviceInter.ServiceInter;

@Component
public class WService implements ServiceInter{
	@Autowired
	JwtTokenInterface jwtGenerator;
	
	@Autowired
	PersonRepository pr;
	
	@Override
	public ResponseEntity<?> login(Person person) {
		try {
	      if(person.getUsername() == null || person.getPassword() == null) {
	      return new ResponseEntity<>("Usuario o password vacio.", HttpStatus.BAD_REQUEST);
	    }
		Person personTest = pr.findByUsernameAndPassword(person.getUsername(), person.getPassword());
		if(personTest == null) {
			return new ResponseEntity<>("Usuario o password invalido.", HttpStatus.BAD_REQUEST);
		}
		 return new ResponseEntity<>(jwtGenerator.generateToken(person), HttpStatus.OK);
	    } catch (Exception e) {
	       return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Override
	public List<Person> findPeople() {
		return pr.findAll();
	}

	@Override
	public String helloWorldAuth() {
		return "holaMundo";
		
	}

}
