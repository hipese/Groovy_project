package com.kdt.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.MemberDTO;
import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectMemberDTO;
import com.kdt.dto.ProjectProgressDTO;
import com.kdt.dto.ProjectScheduleDTO;
import com.kdt.services.MemberService;
import com.kdt.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService PService;
	
	@Autowired
	private MemberService mService;
	
	@PostMapping("/create")
	public ResponseEntity<Integer> newProject(@RequestBody ProjectDTO dto){
		System.out.println(dto.getPmanager());
		int pseq = PService.insertProject(dto);
		MemberDTO mdto = mService.getprofile(dto.getPmanager());
		
		ProjectMemberDTO pmdto = new ProjectMemberDTO();
		pmdto.setId(dto.getPmanager());
		pmdto.setPseq(pseq);
		pmdto.setGroup_name(mdto.getGroup_name());
		int result = PService.insertMember(pmdto);
		
		return ResponseEntity.ok(pseq);
	}
	
	@PostMapping("/addSchedule/{seq}")
	public ResponseEntity<Integer> insertSchedule(@PathVariable int seq, @RequestBody ProjectScheduleDTO dto){
		dto.setPseq(seq);
		
		int result = PService.insertSchedule(dto);
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/addMember/{seq}")
	public ResponseEntity<Integer> insertMember(@PathVariable int seq, @RequestBody ProjectMemberDTO dto){
		dto.setPseq(seq);
		PService.insertMember(dto);
		return ResponseEntity.ok(seq);
	}
	
	@GetMapping
	public ResponseEntity<List<ProjectDTO>> selectAll(){
		List<ProjectDTO> list = PService.selectAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<ProjectDTO>> selectProject(@PathVariable String id){
		List<ProjectDTO> list = PService.selectProject(id);
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
	
	@PutMapping("/update/state")
	public ResponseEntity<Integer> updateState(@RequestBody Map<String,Object> data){
		System.out.println(data.get("pschedule_seq"));
		System.out.println(data.get("pschedule_state"));
		int result = PService.updateState(data);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getManager/{seq}")
	public ResponseEntity<String> getManager(@PathVariable int seq){
		String result = PService.selectManager(seq);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete/{seq}")
	public ResponseEntity<Integer> deleteProject(@PathVariable int seq){
		int result = PService.deleteProject(seq);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/todo/delete/{seq}")
	public ResponseEntity<Integer> deleteTodo(@PathVariable int seq){
		int result = PService.deleteTodo(seq);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete/member/{seq}/{id}")
	public ResponseEntity<Integer> deleteMember(@PathVariable int seq, @PathVariable String id){
		int result = PService.deleteMember(seq, id);
		return ResponseEntity.ok(result);
	}
	

}
