package com.kdt.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Vacation_documentDAO;
import com.kdt.dto.Vacation_documentDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class Vacation_documentService {
	@Autowired
	private Vacation_documentDAO vdao;
	@Autowired
	private HttpSession session;

	public int insert(Vacation_documentDTO dto) {
		String id = (String)session.getAttribute("loginID");
		Timestamp date = new Timestamp(System.currentTimeMillis());
		System.out.println(id);
		dto.setWriter(id);
		dto.setWrite_date(date);
		return vdao.insert(dto);
	}
	
	public List<Vacation_documentDTO> selectVacationComplete(String id){
		return vdao.selectVacationComplete(id);
	}
	
	public List<Vacation_documentDTO> selectVacationWait(String id){
		return vdao.selectVacationWait(id);
	}
	
	public List<Vacation_documentDTO> selectVacationProgress(String id){
		return vdao.selectVacationProgress(id);
	}
	
	public Vacation_documentDTO selectBySeq(int seq) {
		return vdao.selectBySeq(seq);
	}
	
	public int accept(Vacation_documentDTO dto) {
	    return vdao.accept(dto);
	}
	
	public int reject(Vacation_documentDTO dto) {
		return vdao.reject(dto);
	}
}
