package com.kdt.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.kdt.dto.MessageDTO;
import com.kdt.dto.Realtime_NotificationsDTO;
import com.kdt.services.MessageService;
import com.kdt.services.Realtime_NotificationsService;

import jakarta.servlet.http.HttpSession;


@Controller
public class WebSocketController {
	
	@Autowired
    private	SimpMessagingTemplate template;
	
	@Autowired
	private Realtime_NotificationsService rservice;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private HttpSession session;
	
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
	
	@MessageMapping("/message")
	public ResponseEntity<Void> message(@RequestBody Map<String, Object> messageObject) {
		System.out.println(String.valueOf((int)messageObject.get("room_seq")) + " " + (int)messageObject.get("id") + " " + (String)messageObject.get("message") );
//		List<String> list = messageService.WSgetParticipants((int)messageObject.get("room_seq"));
		MessageDTO dto = messageService.WSInsert((int)messageObject.get("room_seq"), (int)messageObject.get("id"), (String)messageObject.get("message"));
		messageService.setUnreadedState((int)messageObject.get("room_seq"));
//		for(String user_id : list) {
//			if(user_id != (String)session.getAttribute("loginID"))
//				template.convertAndSend("/queue/" + user_id, messageObject);
//			template.convertAndSend("/queue/message/" + user_id, messageObject);
//		}
		template.convertAndSend("/topic/message/" + String.valueOf((int)messageObject.get("room_seq")), dto);
		return ResponseEntity.ok().build();
	}
}
