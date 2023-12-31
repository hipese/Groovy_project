package com.kdt.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Sign_documentDAO;
import com.kdt.dto.Sign_documentDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class Sign_documentService {
	@Autowired
	private Sign_documentDAO sdao;
	@Autowired
	private HttpSession session;

	public int insert(Sign_documentDTO dto) {
		String id = (String)session.getAttribute("loginID");
		Timestamp date = new Timestamp(System.currentTimeMillis());
		System.out.println(id);
		dto.setWriter(id);
		dto.setWrite_date(date);
		return sdao.insert(dto);
	}
	
	public List<Sign_documentDTO> selectProgress(String id){
		return sdao.selectProgress(id);
	}
	
	public List<Sign_documentDTO> selectComplete(String id){
		return sdao.selectComplete(id);
	}
	
	public List<Sign_documentDTO> selectWait(String id){
		return sdao.selectWait(id);
	}
	

	public List<Sign_documentDTO> selectReview(String id){
		return sdao.selectReview(id);
	}
	

	public Sign_documentDTO selectBySeq(int seq) {
		return sdao.selectBySeq(seq);
	}
	
	public Sign_documentDTO documentIntoBySeq(int seq) {
		return sdao.documentIntoBySeq(seq);
	}
	
	public int accept(Sign_documentDTO dto) {
	    return sdao.accept(dto);
	}
	
	public int reject(Sign_documentDTO dto) {
		return sdao.reject(dto);
	}
}
