package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.ToDoListBookMarkDTO;

@Repository
public class ToDoListBookMarkDAO {
	@Autowired
	private SqlSession ss;
	public int post(ToDoListBookMarkDTO dto) {
		return ss.insert("ToDoListBookMark.insert",dto);
	}
	public List<ToDoListBookMarkDTO> selectAll (String id) {
		return ss.selectList("ToDoListBookMark.selectAll", id);
	}
	public int delete(int parent_seq) {
		return ss.delete("ToDoListBookMark.delete",parent_seq);
	}
}
