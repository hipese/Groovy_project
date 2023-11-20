package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.MemberDTO;
import com.kdt.services.DeptNoticeService;
import com.kdt.services.MemberService;

@RestController
@RequestMapping("/api/dept_notice")
public class DeptNoticeController {
	
	@Autowired
	private DeptNoticeService DService;
	
	@Autowired
	private MemberService MService;
	
	@GetMapping("/{login}")
	public ResponseEntity<String> selectInfo(@PathVariable("login") String id){
		MemberDTO result = MService.getprofile(id);
		return ResponseEntity.ok(result.getGroup_name());
	}

}
