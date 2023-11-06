package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.commons.Encryption;
import com.kdt.dao.ContactDAO;
import com.kdt.dto.ContactDTO;
import com.kdt.dto.MemberDTO;

@Service
public class ContactService {
	
	@Autowired
	private ContactDAO dao;
	
	public List<ContactDTO> selectAll() {
		return dao.selectAll();
	}
	
	public int insert(MemberDTO dto) {
		try {
			dto.setPassword(Encryption.getSHA512(dto.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao.insert(dto);
	}
	
	public List<String> favorite(String id) {
		return dao.favorite(id);
	}

}
