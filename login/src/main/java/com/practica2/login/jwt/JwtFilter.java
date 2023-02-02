package com.practica2.login.jwt;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("authorization");
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } 
        try {
	        final String token = authHeader.substring(7);
	        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
	        request.setAttribute("claims", claims);
	        request.setAttribute("blog", servletRequest.getParameter("id"));
	        filterChain.doFilter(request, response);
        }catch(Exception e) {
        	System.out.println("Ocurrio un error");
        }
		
	}

}
