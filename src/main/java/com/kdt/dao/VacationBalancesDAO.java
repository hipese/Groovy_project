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
	
	
	public int Initial_Vacation(String id) {
		return db.insert("VacationBalance.Initial_Vacation",id);
	}
	
	public List<VacationBalancesDTO> allVacationList(){
		return db.selectList("VacationBalance.selectAll");
	}
	
	public VacationBalancesDTO myVacation(String memberID) {
		return db.selectOne("VacationBalance.selectVacationByMemberID", memberID);
	}
	
	public VacationBalancesDTO selectIDVacation(String selectID) {
		return db.selectOne("VacationBalance.selectVacationByMemberID", selectID);
	}
	
	public VacationBalancesDTO myVacationUpdate(VacationRequsetDTO vRequset) {
		db.update("VacationBalance.selectmyVacationUpdateByMemberID", vRequset);
		return  db.selectOne("VacationBalance.selectVacationByMemberID", vRequset.getMemberID());
	}
	
	public VacationBalancesDTO addVacation(VacationRequsetDTO vRequset) {
		db.update("VacationBalance.addVacation", vRequset);
		return db.selectOne("VacationBalance.selectVacationByMemberID", vRequset.getMemberID());
	}
	
	public VacationBalancesDTO subtractVacation(VacationRequsetDTO vRequset) {
		db.update("VacationBalance.subtractVacation", vRequset);
		return db.selectOne("VacationBalance.selectVacationByMemberID", vRequset.getMemberID());
	}
	
}
