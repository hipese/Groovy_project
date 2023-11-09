package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.services.DeptNoticeService;

@RestController
@RequestMapping("/api/dept_notice")
public class DeptNoticeController {
	
	@Autowired
	private DeptNoticeService DService;
	
	@GetMapping("/{login}")
	public ResponseEntity<Boolean> selectExcutives(@PathVariable("login") String id){
		boolean result = DService.selectIsExcutives(id);
		return ResponseEntity.ok(result);
	}

}
