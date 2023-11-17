package com.kdt.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.ToDoListDAO;
import com.kdt.dto.TDLTitleDTO;
import com.kdt.dto.ToDoListDTO;

@Service
public class ToDoListService {
	@Autowired
	private ToDoListDAO tdldao;
	
	public int post(ToDoListDTO dto) {
		Timestamp make_date = new Timestamp(System.currentTimeMillis());
		dto.setMake_date(make_date);
		return this.tdldao.post(dto);
	}
	public List<ToDoListDTO> selectAll(String id) {
		return this.tdldao.selectAll(id);
	}
	public int bookmark(ToDoListDTO dto) {
		return this.tdldao.bookmark(dto);
	}
	public int delete(int seq) {
		return this.tdldao.delete(seq);
	}
	public int update(ToDoListDTO dto) {
		return this.tdldao.update(dto);
	}
}
