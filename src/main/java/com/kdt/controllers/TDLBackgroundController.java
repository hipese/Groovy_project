package com.kdt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.TDLBackgroundDTO;
import com.kdt.services.TDLBackgroundService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/tdlbackground")
public class TDLBackgroundController {

	@Autowired
	private TDLBackgroundService tdlbservice;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody TDLBackgroundDTO dto) throws Exception {
		dto.setId((String)session.getAttribute("loginID"));
		tdlbservice.post(dto);
		return ResponseEntity.ok().build();
	}
	@GetMapping
	public ResponseEntity<List<TDLBackgroundDTO>> selectAll() throws Exception {
		List<TDLBackgroundDTO> list = new ArrayList<>();
		list = tdlbservice.selectAll((String)session.getAttribute("loginID"));
		return ResponseEntity.ok(list);
	}
	@PutMapping("/{parent_seq}")
	public ResponseEntity<Integer> update(@RequestBody TDLBackgroundDTO dto) {
		tdlbservice.update(dto);
		return ResponseEntity.ok().build();
	}
}
