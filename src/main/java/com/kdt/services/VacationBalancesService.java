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
	
	public VacationBalancesDTO useVacation(String vactionDate) {
		return dao.myVacation(vactionDate);
	}
	
	public VacationBalancesDTO addVacation(VacationRequsetDTO vRequset) {
		return dao.addVacation(vRequset);
	}
	
	public VacationBalancesDTO subtractVacation(VacationRequsetDTO vRequest) {
		return dao.subtractVacation(vRequest);
	}
}
