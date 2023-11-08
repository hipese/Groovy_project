package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.MailDTO;
import com.kdt.dto.MailReceiptDTO;

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
	
	public MailDTO selectBySeq(int seq){ 
		return db.selectOne("Mails.selectBySeq",seq);
	}	
	
	public List<MailDTO>selectDelInbox(){ 
		return db.selectList("Mails.selectDelInbox");
	}
	
	public List<MailReceiptDTO>selectDelSent(){ 
		return db.selectList("Mails.selectDelSent");
	}
	
	public List<MailReceiptDTO>selectAll(String receipient){ 
		return db.selectList("Mails.selectAll", receipient);
	}

	public List<MailDTO>selectAllSend(String sender){ 
		return db.selectList("Mails.selectAllSend", sender);
	}
	
	public List<MailDTO>selectAllTemp(){ 
		return db.selectList("Mails.selectAllTemp");
	}
	
	public List<MailDTO>selectAllSpam(){ 
		return db.selectList("Mails.selectAllSpam");
	}

	public List<MailDTO>selectAllToMe(){ 
		return db.selectList("Mails.selectAllToMe");
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
