package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.ProjectDAO;
import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectScheduleDTO;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO dao;
	
	public List<ProjectDTO> selectAll(){
		return dao.selectAll();
	}
	
	public List<ProjectScheduleDTO> selectTodo(int seq){
		return dao.selectTodo(seq);
	}

}
