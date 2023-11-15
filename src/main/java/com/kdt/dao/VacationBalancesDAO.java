package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.VacationBalancesDTO;

@Repository
public class VacationBalancesDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<VacationBalancesDTO> allVacationList(){
		return db.selectList("VacationBalance.selectAll");
	}
	
}
