package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.MailDAO;
import com.kdt.dto.MailDTO;

@Service
public class MailService {

	@Autowired
	private MailDAO dao;
	
	// 게시물 추가
		public MailDTO addMail(MailDTO dto) {
			this.dao.insertMail(dto);
			return dto;
		}

		// 게시물 삭제
		public int deleteInbox(Integer seq) {
			return this.dao.deleteInbox(seq);
		}
		
		// 게시물 삭제
		public int deleteSent(Integer seq) {
			return this.dao.deleteSent(seq);
		}

		// 게시물 수정
		public int updateMail(MailDTO dto) {
			return this.dao.update(dto);
		}

		// 모든 게시물 조회
		public List<MailDTO> selectAll() {
			return this.dao.selectAll();
		}

		public List<MailDTO> selectAllSend() {
			return this.dao.selectAllSend();
		}
		
		public List<MailDTO> selectAllTemp() {
			return this.dao.selectAllTemp();
		}
		
		public List<MailDTO> selectAllSpam() {
			return this.dao.selectAllSpam();
		}

		public List<MailDTO> selectAllToMe() {
			return this.dao.selectAllToMe();
		}

		// 특정 게시물 조회
		public MailDTO selectBySeq(Integer seq) {
			return this.dao.selectBySeq(seq);
		}
}
