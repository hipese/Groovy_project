package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.TDLTitleDTO;
import com.kdt.dto.ToDoListDTO;

@Repository
public class ToDoListDAO {
	@Autowired
	private SqlSession ss;
	
	public int post(ToDoListDTO dto) {
		return ss.insert("ToDoList.insert", dto);
	}
	public List<ToDoListDTO> selectAll (String id) {
		return ss.selectList("ToDoList.selectAll", id);
	}
	public int bookmark(ToDoListDTO dto) {
		return ss.update("ToDoList.bookmark",dto);
	}
	public int delete(int seq) {
		return ss.delete("ToDoList.delete", seq);
	}
	public int update(ToDoListDTO dto) {
		return ss.update("ToDoList.update",dto);
	}
}
