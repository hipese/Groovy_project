package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.MailDTO;

@Repository
public class MailDAO {

	@Autowired
	private SqlSession db;
	
	public int insertMail(MailDTO dto) {
		return db.insert("Mails.insert", dto);
	}
	
	public MailDTO selectBySeq(int seq){ 
		return db.selectOne("Mails.selectBySeq",seq);
	}
	
	public List<MailDTO>selectAll(){ 
		return db.selectList("Mails.selectAll");
	}

	public List<MailDTO>selectAllSend(){ 
		return db.selectList("Mails.selectAllSend");
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

	public int deleteInbox(Integer seq) {
		return db.delete("Mails.deleteInbox",seq);
	}
	
	public int deleteSent(Integer seq) {
		return db.delete("Mails.deleteSent",seq);
	}

	public int update(MailDTO dto) {
		return db.update("Mails.update",dto);
	}
}
