package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.VacationBalancesDTO;
import com.kdt.dto.VacationRequsetDTO;

@Repository
public class VacationBalancesDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<VacationBalancesDTO> allVacationList(){
		return db.selectList("VacationBalance.selectAll");
	}
	
	public int addVacation(VacationRequsetDTO vRequset) {
		return db.update("VacationBalance.addVacation", vRequset);
	}
	
	public int subtractVacation(VacationRequsetDTO vRequset) {
		return db.update("VacationBalance.subtractVacation", vRequset);
	}
	
}
