package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.LoginDTO;
import com.kdt.services.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth/")
public class AuthController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private AuthService service;
	
	@RequestMapping("login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws Exception {
		if(service.isMember(loginDTO)) {
			session.setAttribute("loginID", loginDTO.getId());
			System.out.println("ID :" + loginDTO.getId());
			return ResponseEntity.ok(loginDTO.getId());
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> ExceptionHandler(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
