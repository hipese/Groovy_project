package com.kdt.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.kdt.dto.Realtime_NotificationsDTO;
import com.kdt.services.Realtime_NotificationsService;


@Controller
public class WebSocketController {
	
	@Autowired
    	SimpMessagingTemplate template;
	
	@Autowired
	Realtime_NotificationsService rservice;
	
	@MessageMapping("/notice")
	public ResponseEntity<Void> sendMessage(@RequestBody Map<String, String> messageObject) {
		Realtime_NotificationsDTO dto = new Realtime_NotificationsDTO();
		String message = messageObject.get("message");
		String recipient = messageObject.get("recipient");
		System.out.println(message);
		System.out.println(recipient);
		template.convertAndSend("/topic/" + recipient, messageObject);
		rservice.insert(message, recipient);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
