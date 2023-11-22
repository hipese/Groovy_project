package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kdt.dto.PositionRankDTO;
import com.kdt.services.PositionRankService;

@Controller
@RequestMapping("/api/positionRank")
public class PositionRankController {
	
	@Autowired
	PositionRankService pservice;
	
	@GetMapping
	public ResponseEntity<List<PositionRankDTO>> selectAll(){
		List<PositionRankDTO> list=pservice.selectAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/isRanking/{position}/{myposition}")
	public ResponseEntity<Boolean> isRanking(@PathVariable String position, @PathVariable String myposition  ){
		boolean isRank=pservice.isRanking(position,myposition);
		return ResponseEntity.ok(isRank);
	}
}
