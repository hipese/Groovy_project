package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.ToDoListBookMarkDAO;
import com.kdt.dto.ToDoListBookMarkDTO;

@Service
public class ToDoListBookMarkService {
	@Autowired
	private ToDoListBookMarkDAO tdlbmdao;
	
	public int post(ToDoListBookMarkDTO dto) {
		return this.tdlbmdao.post(dto);
	}
	public List<ToDoListBookMarkDTO> selectAll(String id) {
		return this.tdlbmdao.selectAll(id);
	}
	public int delete(int parent_seq) {
		return this.tdlbmdao.delete(parent_seq);
	}
}
