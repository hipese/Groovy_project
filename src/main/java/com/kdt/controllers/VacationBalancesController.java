package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kdt.dto.VacationBalancesDTO;
import com.kdt.dto.VacationRequsetDTO;
import com.kdt.services.VacationBalancesService;

@Controller
@RequestMapping("/api/vacation")
public class VacationBalancesController {
	
	@Autowired
	VacationBalancesService vservice;
	
	@GetMapping
	public ResponseEntity<List> allVacationList(){
		List<VacationBalancesDTO> dto = vservice.allVacationList();
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addVacation(@RequestBody VacationRequsetDTO vRequest){
		vservice.addVacation(vRequest);
		return ResponseEntity.ok("성공!");
	}
	
	@PostMapping("/subtract")
	public ResponseEntity<String> subtractVacation(@RequestBody VacationRequsetDTO vRequest){
		vservice.subtractVacation(vRequest);
		return ResponseEntity.ok("성공!");
	}
	
}
