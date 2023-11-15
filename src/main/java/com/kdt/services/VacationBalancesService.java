package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.VacationBalancesDAO;
import com.kdt.dto.VacationBalancesDTO;

@Service
public class VacationBalancesService {
	
	@Autowired
	VacationBalancesDAO dao;
	
	public List<VacationBalancesDTO> allVacationList(){
		return dao.allVacationList();
	}
	
}
