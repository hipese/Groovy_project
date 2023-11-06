package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.MemberDTO;
import com.kdt.services.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@Autowired
	MemberService mservice;
	
	@GetMapping
	public ResponseEntity<String> memberProfile(){
		return ResponseEntity.ok("성공");
	}

}
