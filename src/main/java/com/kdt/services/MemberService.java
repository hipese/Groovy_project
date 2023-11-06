package com.kdt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.MemberDAO;
import com.kdt.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO dao;
	
	
	public MemberDTO getprofile() {
		return dao.getprofile();
	}
}
