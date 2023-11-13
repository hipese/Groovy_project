package com.kdt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.ToDoListDTO;
import com.kdt.services.ToDoListService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/tdList")
public class ToDoListController {
	
	@Autowired
	private ToDoListService tdlservice;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody ToDoListDTO dto) throws Exception {
		dto.setId((String)session.getAttribute("loginID"));
		tdlservice.post(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ToDoListDTO>> selectAll() throws Exception {
		List<ToDoListDTO> list = new ArrayList<>();
		list = tdlservice.selectAll((String)session.getAttribute("loginID"));
		return ResponseEntity.ok(list);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Integer> bookmark(@RequestBody ToDoListDTO dto) throws Exception {
		tdlservice.bookmark(dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{seq}")
	public ResponseEntity<Integer> delete(@PathVariable Integer seq) throws Exception {
		tdlservice.delete(seq);
		return ResponseEntity.ok().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
