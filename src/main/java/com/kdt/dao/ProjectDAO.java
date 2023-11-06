package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectScheduleDTO;

@Repository
public class ProjectDAO {
	
	@Autowired
	private SqlSession db;
	
	
	//ProjectList
	public List<ProjectDTO> selectAll(){
		return db.selectList("Project.selectAll");
	}
	
	
//	ProjectContent
	public List<ProjectScheduleDTO> selectTodo(int seq){
		return db.selectList("Project.selectTodo",seq);
	}
	
	
	
//	ProjectCreate

}
