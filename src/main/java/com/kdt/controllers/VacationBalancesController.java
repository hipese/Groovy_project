package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kdt.dto.VacationBalancesDTO;
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
	
}
