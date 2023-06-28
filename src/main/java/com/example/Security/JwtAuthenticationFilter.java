package com.example.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import com.example.demo.Service.EmployeeService;
import com.example.demo.security.JwtTokenProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	 private static final String AUTHORIZATION_HEADER = "Authorization";
	    private static final String TOKEN_PREFIX = "Bearer ";

	    private final Logger log = LoggerFactory.getLogger(getClass());
	    private JwtTokenProvider jwtTokenProvider;
	    private EmployeeService employeeService;

	    @Autowired
	    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider,EmployeeService employeeService) {
	        this.jwtTokenProvider = jwtTokenProvider;
	        this.employeeService=employeeService;
	       
	    }

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
	                                    FilterChain filterChain) throws ServletException, IOException {
	        try {
//	        	log.info("received request :" +request);
	            String token = extractTokenFromRequest(request);
	            log.info("received Token :" +token);
	            if (token != null && jwtTokenProvider.validateToken(token)) {
	                String email = jwtTokenProvider.getEmailFromToken(token);
	                UserDetails userDetails = employeeService.loadUserByUsername(email);

	                if (userDetails != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
	                            userDetails, null, userDetails.getAuthorities());
	                    SecurityContextHolder.getContext().setAuthentication(authentication);
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        filterChain.doFilter(request, response);
	    }

	    private String extractTokenFromRequest(HttpServletRequest request) {
	    	String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
	        String method = request.getMethod();
	        String requestURI = request.getRequestURI();
	        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
	        log.info("Received request - Method: {}, URI: {}, Authorization: {}", method, requestURI, authorizationHeader);
	        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
	            return bearerToken.substring(TOKEN_PREFIX.length());
	        }
	        return null;
	    }


}
