package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.MailDTO;
import com.kdt.dto.MailReceiptDTO;
import com.kdt.dto.MailWithMemberDTO;
import com.kdt.dto.RWasteWithMemFileDTO;
import com.kdt.dto.Re_MemberDTO;
import com.kdt.dto.WasteMailDTO;
import com.kdt.dto.WasteRMailDTO;
import com.kdt.dto.WasteWithMemFileDTO;

@Repository
public class MailDAO {

	@Autowired
	private SqlSession db;
	
	public int insertMail(MailDTO dto) {
		return db.insert("Mails.insert", dto);
	}
	
	public int insertReceipt(MailReceiptDTO dto) {
		return db.insert("Mails.insertReceipt", dto);
	}
	
	public int insertWaste(WasteMailDTO dto) {
		return db.insert("Mails.insertWaste", dto);
	}
	
	public int insertRWaste(WasteRMailDTO dto) {
		return db.insert("Mails.insertRWaste", dto);
	}
	
	public MailWithMemberDTO selectBySeq(int seq){ 
		return db.selectOne("Mails.selectBySeq",seq);
	}	
	
	public Re_MemberDTO selectMember(int seq){ 
		return db.selectOne("Mails.selectMember",seq);
	}	
	
	public List<WasteWithMemFileDTO>selectDelInbox(String member_id){ 
		return db.selectList("Mails.selectDelInbox", member_id);
	}
	
	public List<RWasteWithMemFileDTO>selectDelSent(String member_id){ 
		return db.selectList("Mails.selectDelSent",member_id);
	}
	
	public List<MailWithMemberDTO>selectAll(String receipient){ 
		return db.selectList("Mails.selectAll", receipient);
	}

	public List<MailWithMemberDTO>selectAllSend(String sender){ 
		return db.selectList("Mails.selectAllSend", sender);
	}

	public List<MailWithMemberDTO>selectAllToMe(String sender){ 
		return db.selectList("Mails.selectAllToMe", sender);
	}
	
	public int updateInbox(Integer seq) {
		return db.update("Mails.updateInbox",seq);
	}
	
	public int updateSent(Integer seq) {
		return db.update("Mails.updateSent",seq);
	}
	
	public int isRead(Integer seq) {
		return db.update("Mails.isRead",seq);
	}

	public int deleteInbox(Integer seq) {
		return db.delete("Mails.deleteInbox",seq);
	}
	
	public int deleteSent(Integer seq) {
		return db.delete("Mails.deleteSent",seq);
	}

}
