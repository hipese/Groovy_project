package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Realtime_NotificationsDTO;

@Repository
public class Realtime_NotificationsDAO {
	@Autowired
	private SqlSession db;
	
	public int insert(Realtime_NotificationsDTO dto) {
		return db.insert("Realtime.insert", dto);
	}
	
	public List<Realtime_NotificationsDTO> selectUnreadNotifications(String id) {
		return db.selectList("Realtime.selectUnreadNotifications", id);
		
	}
	
	public int updateReadStatus(Realtime_NotificationsDTO dto) {
		return db.update("Realtime.updateReadStatus", dto);	
	}
}
