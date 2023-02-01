package com.practica2.login.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practica2.login.entity.Person;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenImple implements JwtTokenInterface{
	@Value("${jwt.secret}")
	private String secret;
	
	@Override
	public Map<String, String> generateToken(Person person) {
		final Date createdDate = new Date();
		final Date expirationDate = new Date(createdDate.getTime() + 60000);
		
		String jwtToken="";
	    jwtToken = Jwts.builder()
	    		.setSubject(person.getUsername())
	    		.setIssuedAt(createdDate)
	    		.setExpiration(expirationDate)
	    		.signWith(SignatureAlgorithm.HS256, "secret")
	    		.compact();
	    Map<String, String> jwtTokenGen = new HashMap<>();
	    jwtTokenGen.put("token", jwtToken);
	    return jwtTokenGen;
	}

}
