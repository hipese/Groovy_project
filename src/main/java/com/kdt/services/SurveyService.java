package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdt.dao.SurveyDAO;
import com.kdt.dto.SurveyDTO;
import com.kdt.dto.SurveyMultiDTO;
import com.kdt.dto.SurveyMultiResponseDTO;
import com.kdt.dto.SurveyResultDTO;
import com.kdt.dto.SurveyShortDTO;
import com.kdt.dto.SurveyShortResponseDTO;

@Service
public class SurveyService {
	
	@Autowired
	private SurveyDAO dao;
	
	public List<SurveyDTO> selectList(){
		return dao.selectList();
	}
	
	public int insertSurvey(SurveyDTO dto) {
		return dao.insertSurvey(dto);
	}
	
	public int insertShort(SurveyShortDTO dto) {
		return dao.insertShort(dto);
	}
	
	public int insertMulti(SurveyMultiDTO dto){
		return dao.insertMulti(dto);
	}
	
	public SurveyDTO selectSurvey(int seq) {
		return dao.selectSurvey(seq);
	}
	
	public List<SurveyShortDTO> selectShort(int seq){
		return dao.selectShort(seq);
	}
	
	public List<SurveyMultiDTO> selectMulti(int seq){
		return dao.selectMulti(seq);
	}
	
	public int insertShortRes(SurveyShortResponseDTO dto) {
		return dao.insertShortRes(dto);
	}
	
	public int insertMultiRes(SurveyMultiResponseDTO dto) {
		return dao.insertMultiRes(dto);
	}
	
	public List<SurveyResultDTO> selectMultiResult(int seq){
		return dao.selectMultiResult(seq);
	}
	
	public int updateState(int seq) {
		return dao.updateState(seq);
	}
	

}
