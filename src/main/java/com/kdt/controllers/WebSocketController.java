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
    private	SimpMessagingTemplate template;
	
	@Autowired
	private Realtime_NotificationsService rservice;
	
	@MessageMapping("/notice")
	public ResponseEntity<Void> sendMessage(@RequestBody Map<String, Object> messageObject) {
		Realtime_NotificationsDTO dto = new Realtime_NotificationsDTO();
		String message = (String)messageObject.get("message");
		String recipient = (String)messageObject.get("recipient");
		Integer parent_seq = (Integer) messageObject.get("parent_seq");
		System.out.println(message);
		System.out.println(recipient);
		System.out.println(parent_seq);
		template.convertAndSend("/queue/" + recipient, messageObject);
		rservice.insert(message, recipient, parent_seq);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
