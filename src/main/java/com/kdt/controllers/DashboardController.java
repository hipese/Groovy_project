package com.kdt.controllers;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dash")
public class DashboardController {
	
	@PostMapping
	public ResponseEntity<String> checkIn(@RequestPart("id")String id, @RequestPart("date") String date, @RequestPart("time")String time) throws Exception{
		System.out.println(id+" / "+date+" / "+time);
//		String decodedTime = URLDecoder.decode(checkInTime,"utf8");
//		System.out.println(decodedTime);
		         
         String combinedString = date + " " + time;
         
         // SimpleDateFormat을 사용하여 문자열을 Date 객체로 파싱
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy. MM. d. HH:mm:ss");
         Date formeddate = dateFormat.parse(combinedString);
         
         
         Timestamp timestamp = new Timestamp(formeddate.getTime());
         
         System.out.println("타임스탬프: " + timestamp);
		
		return ResponseEntity.ok().build();
	}

}
