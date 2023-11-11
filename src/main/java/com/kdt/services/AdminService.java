package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.AdminDAO;
import com.kdt.dto.DepartmentDTO;
import com.kdt.dto.MemberDTO;
import com.kdt.dto.PositionDTO;

@Service
public class AdminService {

	@Autowired
	private AdminDAO dao;

	public MemberDTO insert(MemberDTO dto) {
		this.dao.insert(dto);
		return dto;
	}

	public DepartmentDTO insertDept(DepartmentDTO dto) {
		this.dao.insertDept(dto);
		return dto;
	}

	public PositionDTO insertPosition(PositionDTO dto) {
		this.dao.insertPosition(dto);
		return dto;
	}

	public boolean isMember(String id) {
		int count = dao.isMember(id);
		return count > 0;
	}

	public List<MemberDTO> selectAllUser() {
		return this.dao.selectAllUser();
	}

	public List<MemberDTO> selectAllInactive() {
		return this.dao.selectAllInactive();
	}

	public List<DepartmentDTO> selectAllDept() {
		return this.dao.selectAllDept();
	}

	public List<PositionDTO> selectAllPosition() {
		return this.dao.selectAllPosition();
	}

	public int delete(String id) {
		return this.dao.delete(id);
	}

	public int deleteDept(String dept_name) {
		return this.dao.deleteDept(dept_name);
	}

	public int deletePosition(String position) {
		return this.dao.deletePosition(position);
	}

	public int update(MemberDTO dto) {
		return this.dao.update(dto);
	}

	public int updateInactive(MemberDTO dto) {
		return this.dao.updateInactive(dto);
	}
	
	public int updatePassword(String password, String id) {
		return this.dao.updatePassword(password, id);
	}
}
