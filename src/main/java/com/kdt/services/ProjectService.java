package com.kdt.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.ProjectDAO;
import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectMemberDTO;
import com.kdt.dto.ProjectProgressDTO;
import com.kdt.dto.ProjectScheduleDTO;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO dao;
	
	public List<ProjectDTO> selectAll(){
		return dao.selectAll();
	}
	
	public List<ProjectDTO> selectProject(String id){
		return dao.selectProject(id);
	}
	
	public List<ProjectScheduleDTO> selectTodo(int seq){
		return dao.selectTodo(seq);
	}
	
	public List<ProjectMemberDTO> selectMember(int seq){
		return dao.selectMember(seq);
	}
	
	public List<ProjectProgressDTO> selectProgress(int seq){
		return dao.selectProgress(seq);
	}
	
	public int insertSchedule(ProjectScheduleDTO dto) {
		return dao.insertSchedule(dto);
	}
	
	public int insertProject(ProjectDTO dto) {
		return dao.insertProject(dto);
	}
	public int insertMember(ProjectMemberDTO dto) {
		return dao.insertMember(dto);
	}
	
	public int updateState(Map<String,Object> data) {
		return dao.updateState(data);		
	}
	
	public String selectManager(int seq) {
		return dao.selectManager(seq);
	}
	
	public int deleteProject(int seq) {
		return dao.deleteProject(seq);
	}
	
	public int deleteTodo(int seq) {
		return dao.deleteTodo(seq);
	}
	
	public int deleteMember(int pseq, String id) {
		Map<String, Object> param = new HashMap<>();
		
		param.put("pseq", pseq);
		param.put("id", id);
		
		return dao.deleteMember(param);
	}
}
