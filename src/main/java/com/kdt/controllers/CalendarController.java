package com.kdt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.CalendarDTO;
import com.kdt.services.CalendarService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService calservice;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody CalendarDTO dto) throws Exception {
		dto.setId((String)session.getAttribute("loginID"));
		calservice.post(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CalendarDTO>> selectAll() throws Exception {
		List<CalendarDTO> list = new ArrayList<>();
		list = calservice.selectAll((String)session.getAttribute("loginID"));
		return ResponseEntity.ok(list);
	}
	@DeleteMapping("/{seq}")
	public ResponseEntity<Integer> delete(@PathVariable Integer seq) throws Exception {
		calservice.delete(seq);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/{seq}")
	public ResponseEntity<Integer> update(@RequestBody CalendarDTO dto) throws Exception {
		calservice.update(dto);
		return ResponseEntity.ok().build();
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
