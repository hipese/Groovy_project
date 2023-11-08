package com.kdt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.DepartmentDTO;
import com.kdt.dto.MemberDTO;
import com.kdt.dto.SearchTermDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession db;
	
	public MemberDTO getprofile(String id) {
		return db.selectOne("Member.selectprofile",id);
	}
	
	public int updateImage(Map<String, Object> params) {
		System.out.println(params);
		return db.update("Member.ImageChange",params);
	}
	
	public int updateContact(Map<String, Object> params) {
		System.out.println(params);
		return db.update("Member.updateContact",params);
	}
	
	public List<DepartmentDTO> departmentAll() {
		return db.selectList("Member.departmentAll");
	}
	
	public List<SearchTermDTO> selectedEmployee() {
		return db.selectList("Member.selectedEmployeeAll");
	}
	
	public SearchTermDTO selectApprover(String selectedRow) {
		return db.selectOne("Member.selectApprover",selectedRow);
	}
	
}
