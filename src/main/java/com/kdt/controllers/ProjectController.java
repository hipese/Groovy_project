package com.kdt.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectMemberDTO;
import com.kdt.dto.ProjectProgressDTO;
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
	
	@GetMapping("/progress/{seq}")
	public ResponseEntity<List<Map<String,Object>>> selectProgress(@PathVariable int seq){
		List<ProjectProgressDTO> list = PService.selectProgress(seq);
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for(ProjectProgressDTO dto : list) {
			Map<String,Object> map = new HashMap<String, Object>();
			if(dto.getState().equals("0")) {
				map.put("id", "해야할일");
			}else if(dto.getState().equals("1")) {
				map.put("id", "진행중");
			}else {
				map.put("id", "완료");
			}
			
			map.put("value", dto.getCount());
			data.add(map);
		}
		
		return ResponseEntity.ok(data);
	}
	
	@PostMapping("/addSchedule/{seq}")
	public ResponseEntity<Integer> insertSchedule(@PathVariable int seq, @RequestBody ProjectScheduleDTO dto){
		System.out.println(dto.getPschedule_importance());
		dto.setPseq(seq);
		
		int result = PService.insertSchedule(dto);
		
		return ResponseEntity.ok(result);
	}

}
