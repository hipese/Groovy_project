package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.ContactDTO;
import com.kdt.dto.FavoriteDTO;
import com.kdt.dto.MemberDTO;

@Repository
public class ContactDAO {

	@Autowired
	private SqlSession db;
	
	public List<ContactDTO> selectAll() {
		return db.selectList("Contact.selectAll");
	}
	
	public int insert(MemberDTO dto) {
		return db.insert("Contact.insert", dto);
	}
	
	public List<String> favorite(String id) {
		return db.selectList("Contact.favorite", id);
	}
	
	public int setFavorite(FavoriteDTO dto) {
		return db.insert("Contact.setFavorite", dto);
	}
	
	public int delFavorite(FavoriteDTO dto) {
		return db.delete("Contact.delFavorite", dto);
	}
}
