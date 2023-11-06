package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.ContactDTO;
import com.kdt.dto.MemberDTO;
import com.kdt.services.ContactService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/api/contact/")
@RestController
public class ContactController {

	@Autowired
	private ContactService service;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("selectAll")
	public ResponseEntity<List<ContactDTO>> getContacts() {
		return ResponseEntity.ok(service.selectAll());
	}
	
	@PostMapping("insert")
	public ResponseEntity<Void> post(MemberDTO dto) {
		int result = service.insert(dto);
		if(result == 1) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("favorite")
	public ResponseEntity<List<String>> getFavorite() {
		if(session.getAttribute("loginID") == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} else
		return ResponseEntity.ok(service.favorite((String)session.getAttribute("loginID")));
	}
}
