package com.kdt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.ProjectDTO;
import com.kdt.dto.ProjectMemberDTO;
import com.kdt.dto.ProjectProgressDTO;
import com.kdt.dto.ProjectScheduleDTO;

@Repository
public class ProjectDAO {
	
	@Autowired
	private SqlSession db;
	
	
	//ProjectList
	public List<ProjectDTO> selectAll(){
		return db.selectList("Project.selectAll");
	}
	
	public List<ProjectDTO> selectProject(String id){
		return db.selectList("Project.selectProject",id);
	}
	
	
//	ProjectContent
	public List<ProjectScheduleDTO> selectTodo(int seq){
		return db.selectList("Project.selectTodo",seq);
	}
	
	public List<ProjectMemberDTO> selectMember(int seq){
		return db.selectList("Project.selectMember",seq);
	}
	
	public List<ProjectProgressDTO> selectProgress(int seq){
		return db.selectList("Project.selectProgress",seq);
	}
	
	public int insertSchedule(ProjectScheduleDTO dto) {
		return db.insert("Project.insertSchedule",dto);
	}
	
	public int updateState(Map<String,Object> data) {
		return db.update("Project.updateState",data);
	}
	
//	ProjectCreate
	
	public int insertProject(ProjectDTO dto) {
		db.insert("Project.insertProject",dto);
		return dto.getPseq();
	}
	
	public int insertMember(ProjectMemberDTO dto) {
		return db.insert("Project.insertProjectMember",dto);
	}
	
	public String selectManager(int seq) {
		return db.selectOne("Project.selectManager",seq);
	}
	
	public int deleteProject(int seq) {
		return db.delete("Project.deleteProject",seq);
	}

}
