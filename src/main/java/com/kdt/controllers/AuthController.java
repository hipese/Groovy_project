package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws Exception {
		if (service.isMember(loginDTO)) {
			session.setAttribute("loginID", loginDTO.getId());
			System.out.println("ID :" + loginDTO.getId());
			return ResponseEntity.ok(loginDTO.getId());
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("logout")
	public ResponseEntity<String> logout() {
		String id = (String) session.getAttribute("loginID");
		if (id != null && !id.isEmpty()) {
			session.removeAttribute("loginID"); 
			return ResponseEntity.ok("로그아웃 되었습니다.");
		}
		return ResponseEntity.badRequest().body("로그인되어 있지 않습니다.");
	}

	@GetMapping("isLogined")
	public ResponseEntity<String> isLogined() {
		String id = (String) session.getAttribute("loginID");
		return ResponseEntity.ok(id);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> ExceptionHandler(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
