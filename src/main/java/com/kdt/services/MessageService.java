package com.kdt.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.MessageDAO;
import com.kdt.dto.ChattingRoomDTO;
import com.kdt.dto.MessageDTO;
import com.kdt.dto.ParticipantDTO;
import com.kdt.dto.RoomInfoDTO;
import com.kdt.dto.RoomProfileDTO;

@Service
public class MessageService {

	@Autowired
	private MessageDAO dao;
	
	public void createRoomAndAddParticipants(String room_name, List<String> list) {
		ChattingRoomDTO dto = new ChattingRoomDTO();
		ParticipantDTO pdto = new ParticipantDTO();
		dto.setRoom_name(room_name);
		dto = dao.createRoom(dto);
		pdto.setRoom_seq(dto.getSeq());
		for (String user_id : list) {
			pdto.setUser_id(user_id);
			dao.addParticipants(pdto);
		}
		dao.initRoom(new MessageDTO(0,list.get(list.size()-1),dto.getSeq(),"",null,false));
	}
	
	public List<RoomInfoDTO> getRoomInfo(String id) {
		return dao.getRoomInfo(id);
	}
	
	
	public List<RoomProfileDTO> getProfiles(String id) {
		return dao.getProfiles(id);
	}
	
	public List<MessageDTO> getRecentMessage(String id) {
		return dao.getRecentMessage(id);
	}
	
	
}
