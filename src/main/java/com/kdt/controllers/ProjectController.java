package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectMemberDTO;
import com.kdt.dto.ProjectScheduleDTO;
import com.kdt.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService PService;
	
	@GetMapping
	public ResponseEntity<List<ProjectDTO>> selectAll(){
		List<ProjectDTO> list = PService.selectAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/todo/{seq}")
	public ResponseEntity<List<ProjectScheduleDTO>> selectTodo(@PathVariable int seq){
		List<ProjectScheduleDTO> list = PService.selectTodo(seq);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/member/{seq}")
	public ResponseEntity<List<ProjectMemberDTO>> selectMember(@PathVariable int seq){
		List<ProjectMemberDTO> list = PService.selectMember(seq);
		return ResponseEntity.ok(list);
	}

}
