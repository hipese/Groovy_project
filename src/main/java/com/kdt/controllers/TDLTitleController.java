package com.kdt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.TDLTitleDTO;
import com.kdt.services.TDLTitleService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/tdltitle")
public class TDLTitleController {

	@Autowired
	private TDLTitleService tdltservice;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody TDLTitleDTO dto) throws Exception {
		System.out.println(dto.getId() + " : " + dto.getTitle() + " : " + dto.getParent_seq());
		tdltservice.post(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{parent_seq}")
	public ResponseEntity<List<TDLTitleDTO>> selectAll(int parent_seq) throws Exception {
		System.out.println(parent_seq);
		List<TDLTitleDTO> list = new ArrayList<>();
		list = tdltservice.selectAll(parent_seq);
		return ResponseEntity.ok(list);
	}
	@DeleteMapping("/{seq}")
	public ResponseEntity<Integer> delete(int seq) throws Exception {
		tdltservice.delete(seq);
		return ResponseEntity.ok().build();
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
