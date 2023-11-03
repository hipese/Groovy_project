package com.kdt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.AttendenceDAO;

@Service
public class AttendenceService {
	
	@Autowired
	private AttendenceDAO dao;
	
	

}
