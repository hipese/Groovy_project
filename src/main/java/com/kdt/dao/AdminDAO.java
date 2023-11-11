package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.DepartmentDTO;
import com.kdt.dto.MemberDTO;
import com.kdt.dto.PositionDTO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession db;

	public int insert(MemberDTO dto) {
		return db.insert("Admins.insert", dto);
	}

	public int insertDept(DepartmentDTO dto) {
		return db.insert("Admins.insertDept", dto);
	}

	public int insertPosition(PositionDTO dto) {
		return db.insert("Admins.insertPosition", dto);
	}

	public int isMember(String id) {
		return db.selectOne("Admins.isMember", id);
	}

	public List<MemberDTO>selectAllUser(){ 
		return db.selectList("Admins.selectAllUser");
	}

	public List<MemberDTO>selectAllInactive(){ 
		return db.selectList("Admins.selectAllInactive");
	}

	public List<DepartmentDTO>selectAllDept(){ 
		return db.selectList("Admins.selectAllDept");
	}

	public List<PositionDTO>selectAllPosition(){ 
		return db.selectList("Admins.selectAllPosition");
	}

	public int delete(String id) {
		return db.delete("Admins.delete",id);
	}

	public int deleteDept(String seq) {
		return db.delete("Admins.deleteDept",seq);
	}

	public int deletePosition(String seq) {
		return db.delete("Admins.deletePosition",seq);
	}

	public int update(MemberDTO dto) {
		return db.update("Admins.update",dto);
	}

	public int updateInactive(MemberDTO dto) {
		return db.update("Admins.updateInactive",dto);
	}

	public int updatePassword(String password, String id) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("password", password);
		paramMap.put("id", id);
		return db.update("Admins.updatePassword",paramMap);
	}

}
