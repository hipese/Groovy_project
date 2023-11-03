package com.kdt.controllers;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.AttendenceDTO;
import com.kdt.services.AttendenceService;

@RestController
@RequestMapping("/api/dash")
public class DashboardController {
	
	@Autowired
	private AttendenceService AtdService;

	
	@PostMapping("/checkin")
	public ResponseEntity<Integer> checkIn(@RequestPart("id")String id, @RequestPart("date") String date, @RequestPart("time")String time) throws Exception{
		System.out.println(id+" / "+date+" / "+time);
		         
         String combinedString = date + " " + time;
         
         // SimpleDateFormat을 사용하여 문자열을 Date 객체로 파싱
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy. MM. d. HH:mm:ss");
         Date formeddate = dateFormat.parse(combinedString);
         
         
         Timestamp timestamp = new Timestamp(formeddate.getTime());
         
         System.out.println("타임스탬프: " + timestamp);
         
         AttendenceDTO dto = new AttendenceDTO();
         
         dto.setId(id);
         dto.setWorkstart(timestamp);
         
         int result = AtdService.insertCheckIn(dto);
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<Integer> checkout(@RequestPart("id")String id, @RequestPart("date") String date, @RequestPart("time")String time) throws Exception{
		System.out.println(id+" / "+date+" / "+time);
		         
         String combinedString = date + " " + time;
         
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy. MM. d. HH:mm:ss");
         Date formeddate = dateFormat.parse(combinedString);
         
         
         Timestamp timestamp = new Timestamp(formeddate.getTime());
         
         System.out.println("타임스탬프: " + timestamp);
         
         AttendenceDTO dto = new AttendenceDTO();
         
         dto.setId(id);
         dto.setWorkend(timestamp);
         
		return ResponseEntity.ok(1);
	}
	
	@GetMapping("/workstart/{id}")
	public ResponseEntity<AttendenceDTO> workstart(@PathVariable String id){
		System.out.println(id);
		AttendenceDTO dto = AtdService.selectWorkStart(id);		
		
		return ResponseEntity.ok(dto);
	}
	
	

}
