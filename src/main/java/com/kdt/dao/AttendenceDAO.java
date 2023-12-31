package com.kdt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.AttendenceDTO;

@Repository
public class AttendenceDAO {
	
	@Autowired
	private SqlSession db;
	
	public int insertCheckIn(AttendenceDTO dto) {
		return db.insert("Attendence.insertCheckIn", dto);
	}
	
	public AttendenceDTO selectWorkStart(String id) {
		return db.selectOne("Attendence.selectWorkStart",id);
	}
	
	public int updateWorkEnd(AttendenceDTO dto) {
		return db.update("Attendence.updateWorkEnd",dto);
	}
	
	public int attendenceCount(String id) {
		return db.selectOne("Attendence.attendenceCount", id);
	}
	
	public AttendenceDTO myAttendence(Map<String, Object> parms) {
		return db.selectOne("Attendence.myAttendence",parms);
	}
	
	public List<AttendenceDTO> selectById(String id) {
		return db.selectList("Attendence.selectByID", id);
	}
	
	public List<AttendenceDTO> detailsByID(String id) {
		return db.selectList("Attendence.detailsByID", id);
	}
	
}
