package com.kdt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.commons.Encryption;
import com.kdt.dao.AuthDAO;
import com.kdt.dto.LoginDTO;

@Service
public class AuthService {
	
	@Autowired
	private AuthDAO dao;
	
	public boolean isMember(LoginDTO dto) throws Exception {
		dto.setPassword(Encryption.getSHA512(dto.getPassword()));
		if(dao.isMember(dto) == null)
			return false;
		else
			return true;
		
	}
}
