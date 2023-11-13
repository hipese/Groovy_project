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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.ToDoListBookMarkDTO;
import com.kdt.dto.ToDoListDTO;
import com.kdt.services.ToDoListBookMarkService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/tdlbookmark")
public class ToDoListBookMarkController {
	
	@Autowired
	private ToDoListBookMarkService tdlbmservice;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody ToDoListBookMarkDTO dto) throws Exception {
		tdlbmservice.post(dto);
		return ResponseEntity.ok().build();
	}
	@GetMapping
	public ResponseEntity<List<ToDoListBookMarkDTO>> selectAll() throws Exception {
		List<ToDoListBookMarkDTO> list = new ArrayList<>();
		list = tdlbmservice.selectAll((String)session.getAttribute("loginID"));
		return ResponseEntity.ok(list);
	}
	@DeleteMapping("/{parent_seq}")
	public ResponseEntity<Integer> delete(@PathVariable Integer parent_seq) throws Exception {
		tdlbmservice.delete(parent_seq);
		return ResponseEntity.ok().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}
