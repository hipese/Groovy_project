package com.kdt.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.MemberDAO;
import com.kdt.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;

	public MemberDTO getprofile(String id) {
		return dao.getprofile(id);
	}

	public int updateImage(String id, String changeImage) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("changeImage", changeImage);

		return dao.updateImage(params);
	}
	
	public int updateContact(String id, String contact) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("contact", contact);
		
		return dao.updateContact(params);
	}
	
}
