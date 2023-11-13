package com.kdt.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey")
public class SurveyConrtoller {
	
	@PostMapping
	public ResponseEntity<String> insertSurvey(@RequestBody List<HashMap<String, Object>> param){
		
		for(HashMap<String,Object> data : param) {
			System.out.println(data.get("type"));
			System.out.println(data.get("questions"));
			
		}
		System.out.println();
		
		return ResponseEntity.ok(null);
	}

}

