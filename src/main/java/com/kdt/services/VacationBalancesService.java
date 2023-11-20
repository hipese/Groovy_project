package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.VacationBalancesDAO;
import com.kdt.dto.VacationBalancesDTO;
import com.kdt.dto.VacationRequsetDTO;

@Service
public class VacationBalancesService {
	
	@Autowired
	VacationBalancesDAO dao;
	
	public List<VacationBalancesDTO> allVacationList(){
		return dao.allVacationList();
	}
	
	public VacationBalancesDTO myVacation(String memberID) {
		return dao.myVacation(memberID);
	}
	
	public VacationBalancesDTO selectIDVacation(String selectID) {
		return dao.selectIDVacation(selectID);
	}
	
	
	public VacationBalancesDTO myVacationUpdate(String memberID, int total_vactionDate) {
		VacationRequsetDTO vRequest =new VacationRequsetDTO(memberID,total_vactionDate);
		return dao.myVacationUpdate(vRequest);
	}
	
	
	public VacationBalancesDTO addVacation(VacationRequsetDTO vRequset) {
		return dao.addVacation(vRequset);
	}
	
	public VacationBalancesDTO subtractVacation(VacationRequsetDTO vRequest) {
		return dao.subtractVacation(vRequest);
	}
}
