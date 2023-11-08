package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.MailDAO;
import com.kdt.dto.MailDTO;
import com.kdt.dto.MailReceiptDTO;

@Service
public class MailService {

	@Autowired
	private MailDAO dao;

	// 추가
	public MailDTO addMail(MailDTO dto) {
		this.dao.insertMail(dto);
		return dto;
	}

	public MailReceiptDTO insertReceipt(MailReceiptDTO dto) {
		this.dao.insertReceipt(dto);
		return dto;
	}

	// 특정 조회
	public MailDTO selectBySeq(Integer seq) {
		return this.dao.selectBySeq(seq);
	}

	// 조회
	public List<MailDTO> selectDelInbox() {
		return this.dao.selectDelInbox();
	}

	public List<MailReceiptDTO> selectDelSent() {
		return this.dao.selectDelSent();
	}

	public List<MailReceiptDTO> selectAll(String receipient) {
		return this.dao.selectAll(receipient);
	}

	public List<MailDTO> selectAllSend(String sender) {
		return this.dao.selectAllSend(sender);
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

	// 휴지통으로

	public int updateInbox(Integer seq) {
		return this.dao.updateInbox(seq);
	}

	public int updateSent(Integer seq) {
		return this.dao.updateSent(seq);
	}
	
	// 읽음 표시
	
	public int isRead(Integer seq) {
		return this.dao.isRead(seq);
	}

	// 완전 삭제
	public int deleteInbox(Integer seq) {
		return this.dao.deleteInbox(seq);
	}

	public int deleteSent(Integer seq) {
		return this.dao.deleteSent(seq);
	}

}
