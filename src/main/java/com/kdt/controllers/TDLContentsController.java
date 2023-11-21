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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.TDLContentsDTO;
import com.kdt.services.TDLContentsService;

@RestController
@RequestMapping("api/tdlcontents")
public class TDLContentsController {
	@Autowired
	private TDLContentsService tdlcservice;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody TDLContentsDTO dto) throws Exception {
		tdlcservice.post(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{parent_seq}")
	public ResponseEntity<List<TDLContentsDTO>> selectAll(int parent_seq) throws Exception {
		List<TDLContentsDTO> list = new ArrayList<>();
		list = tdlcservice.selectAll(parent_seq);
		return ResponseEntity.ok(list);
	}
	@DeleteMapping("/{parent_seq}")
	public ResponseEntity<Integer> deleteAll(int parent_seq) throws Exception {
		tdlcservice.deleteAll(parent_seq);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping
	public ResponseEntity<Integer> delete(int seq) throws Exception {
		tdlcservice.delete(seq);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/order")
	public ResponseEntity<Integer> swcontents(@RequestBody List<TDLContentsDTO> dtos) {
		for (TDLContentsDTO dto : dtos) {
	        tdlcservice.swcontents(dto);
	    }
		return ResponseEntity.ok().build();
	}
	@PutMapping("/{seq}")
	public ResponseEntity<Integer> update(@PathVariable int seq, @RequestBody TDLContentsDTO dto) throws Exception {
		dto.setSeq(seq);
		tdlcservice.update(dto);
		return ResponseEntity.ok().build();
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
