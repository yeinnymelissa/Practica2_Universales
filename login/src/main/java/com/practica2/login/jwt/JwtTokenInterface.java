package com.practica2.login.jwt;

import java.util.Map;

import com.practica2.login.entity.Person;

public interface JwtTokenInterface {
	Map<String, String> generateToken(Person person);
}
