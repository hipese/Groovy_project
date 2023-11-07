package com.kdt.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.CalendarDAO;
import com.kdt.dto.CalendarDTO;

@Service
public class CalendarService {
	@Autowired
	private CalendarDAO caldao;
	
	public int post(CalendarDTO dto) {
		Timestamp write_date = new Timestamp(System.currentTimeMillis());
		dto.setWrite_date(write_date);
		return this.caldao.post(dto);
	}
	
	public List<CalendarDTO> selectAll(String id) throws Exception {
		return this.caldao.selectAll(id);
	}
}
