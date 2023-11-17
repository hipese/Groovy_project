package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.AttendenceDAO;
import com.kdt.dto.AttendenceDTO;

@Service
public class AttendenceService {
	
	@Autowired
	private AttendenceDAO dao;
	
	public int insertCheckIn(AttendenceDTO dto) {
		return dao.insertCheckIn(dto);
	}
	
	public AttendenceDTO selectWorkStart(String id) {
		return dao.selectWorkStart(id);
	}
	
	public int updateWorkEnd(AttendenceDTO dto) {
		return dao.updateWorkEnd(dto);
	}
	
	public List<AttendenceDTO> selectByID(String id) {
		return dao.selectById(id);
	}
	
	public List<AttendenceDTO> detailsByID(String id) {
		return dao.detailsByID(id);
	}
	

}
