package com.kdt.dto;

import java.sql.Timestamp;

public class AttendenceCheckDTO {
	private String id;
	private Timestamp today;
	
	
	public AttendenceCheckDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AttendenceCheckDTO(String id, Timestamp today) {
		super();
		this.id = id;
		this.today = today;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getToday() {
		return today;
	}
	public void setToday(Timestamp today) {
		this.today = today;
	} 
}
