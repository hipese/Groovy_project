package com.kdt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.DeptNoticeDAO;

@Service
public class DeptNoticeService {
	
	@Autowired
	private DeptNoticeDAO dao;
	
	public boolean selectIsExcutives(String id) {
		return dao.selectIsExcutives(id);
	}

}
