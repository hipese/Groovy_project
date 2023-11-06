package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.MemberDTO;
import com.kdt.services.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	HttpSession session;
	
	@GetMapping
	public ResponseEntity<MemberDTO> memberProfile(){
		String id = (String)session.getAttribute("loginID");
		System.out.println("로그인 한놈은 누구인가?"+id);
		
		MemberDTO dto =mservice.getprofile(id);
		System.out.println(dto.getContact()+" : "+dto.getGroup_name()+" : "+dto.getPosition());
		return ResponseEntity.ok(dto);
	}

}
