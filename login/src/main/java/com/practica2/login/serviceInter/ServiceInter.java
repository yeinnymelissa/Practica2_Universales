package com.practica2.login.serviceInter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica2.login.entity.Person;

@RestController
@RequestMapping("/api")
@CrossOrigin
public interface ServiceInter {

	
	@PostMapping("/noauth/login")
	public ResponseEntity<?> login(@RequestBody Person person);
	
	@GetMapping("/findPeople")
	public List<Person> findPeople();
	
	@GetMapping("/auth/hola")
	public String helloWorldAuth();
}
