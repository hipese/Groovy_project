package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.AttendenceDTO;
import com.kdt.services.AttendenceService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/attend")
public class AttendenceController {
	
	@Autowired
	private HttpSession session;

	@Autowired
	private AttendenceService AtdService;
	
	@GetMapping
	public ResponseEntity<List<AttendenceDTO>> selectByID() {
		String id = (String)session.getAttribute("loginID");
		System.out.println(id);
		List<AttendenceDTO> list = AtdService.selectByID(id);
		return ResponseEntity.ok(list);
	}
}
