package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class WebSocketController {
	
	@Autowired
    	SimpMessagingTemplate template;
	
	@MessageMapping("/user")
	public ResponseEntity<Void> sendMessage(@RequestBody String id) {
		System.out.println(id);
		template.convertAndSend("/topic/a", id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
