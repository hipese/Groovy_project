package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.MailDAO;
import com.kdt.dto.MailDTO;
import com.kdt.dto.MailReceiptDTO;
import com.kdt.dto.MailWithMemberDTO;
import com.kdt.dto.RWasteWithMemFileDTO;
import com.kdt.dto.Re_MemberDTO;
import com.kdt.dto.WasteMailDTO;
import com.kdt.dto.WasteRMailDTO;
import com.kdt.dto.WasteWithMemFileDTO;

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
	
	public WasteMailDTO insertWaste(WasteMailDTO dto) {
		this.dao.insertWaste(dto);
		return dto;
	}
	
	public WasteRMailDTO insertRWaste(WasteRMailDTO dto) {
		this.dao.insertRWaste(dto);
		return dto;
	}

	// 특정 조회
	public MailWithMemberDTO selectBySeq(Integer seq) {
		return this.dao.selectBySeq(seq);
	}
	
	public Re_MemberDTO selectMember(Integer seq) {
		return this.dao.selectMember(seq);
	}

	// 조회
	public List<WasteWithMemFileDTO> selectDelInbox(String member_id) {
		return this.dao.selectDelInbox(member_id);
	}

	public List<RWasteWithMemFileDTO> selectDelSent(String member_id) {
		return this.dao.selectDelSent(member_id);
	}

	public List<MailWithMemberDTO> selectAll(String receipient) {
		return this.dao.selectAll(receipient);
	}

	public List<MailWithMemberDTO> selectAllSend(String sender) {
		return this.dao.selectAllSend(sender);
	}

	public List<MailWithMemberDTO> selectAllToMe(String sender) {
		return this.dao.selectAllToMe(sender);
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
