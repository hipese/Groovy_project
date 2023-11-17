package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.MessageDTO;
import com.kdt.dto.ParticipantDTO;
import com.kdt.dto.RoomInfoDTO;
import com.kdt.dto.RoomProfileDTO;
import com.kdt.services.MessageService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/api/message/")
@RestController
public class MessageController {

	@Autowired
	private HttpSession session;
	@Autowired
	private MessageService service;
	
	@PostMapping("createRoom")
	public ResponseEntity<Void> createRoom(@RequestBody List<String> list,  String room_name) {
		list.add((String)session.getAttribute("loginID"));
		System.out.println("room_name : " + room_name + " / Participle List : " + list);
		service.createRoomAndAddParticipants(room_name, list);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("getRoomInfo")
	public ResponseEntity<List<RoomInfoDTO>> getRoomInfo() {
		return ResponseEntity.ok(service.getRoomInfo((String)session.getAttribute("loginID")));
	}
	
	@GetMapping("getProfiles")
	public ResponseEntity<List<RoomProfileDTO>> getProfiles() {
		return ResponseEntity.ok(service.getProfiles((String)session.getAttribute("loginID")));
	}
	
	@GetMapping("getRecentMessage")
	public ResponseEntity<List<MessageDTO>>getRecentMessage() {
		return ResponseEntity.ok(service.getRecentMessage((String)session.getAttribute("loginID")));
	}
	
	@GetMapping("selectByRoomSeq")
	public ResponseEntity<List<MessageDTO>> getMessagesByRoomSeq(String room_seq) {
		return ResponseEntity.ok(service.getMessagesByRoomSeq(room_seq));
	}
	
	@PutMapping("readMessage")
	public ResponseEntity<Integer> readMessage(String room_seq) {
		return ResponseEntity.ok(service.readMessage(new ParticipantDTO(Integer.parseInt(room_seq), (String)session.getAttribute("loginID"), true)));
	}
	
	@DeleteMapping("leaveRoom")
	public ResponseEntity<Integer> leaveRoom(String room_seq) {
		return ResponseEntity.ok(service.leaveRoom((String)session.getAttribute("loginID"), room_seq));
	}
}
