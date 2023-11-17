package com.kdt.dto;

import java.sql.Timestamp;

public class AttendenceDTO {

	private int attendanceid;
	private String id;
	private Timestamp workstart;
	private Timestamp workend;
	private Timestamp overendtime;
	private Timestamp totalWorkTime;
	private int status;
	
	
	public AttendenceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendenceDTO(int attendanceid, String id, Timestamp workstart, Timestamp workend, Timestamp overendtime,
			Timestamp totalWorkTime, int status) {
		super();
		this.attendanceid = attendanceid;
		this.id = id;
		this.workstart = workstart;
		this.workend = workend;
		this.overendtime = overendtime;
		this.totalWorkTime = totalWorkTime;
		this.status = status;
	}
	
	public int getAttendanceid() {
		return attendanceid;
	}
	public void setAttendanceid(int attendanceid) {
		this.attendanceid = attendanceid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getWorkstart() {
		return workstart;
	}
	public void setWorkstart(Timestamp workstart) {
		this.workstart = workstart;
	}
	public Timestamp getWorkend() {
		return workend;
	}
	public void setWorkend(Timestamp workend) {
		this.workend = workend;
	}
	public Timestamp getOverendtime() {
		return overendtime;
	}
	public void setOverendtime(Timestamp overendtime) {
		this.overendtime = overendtime;
	}
	public Timestamp getTotalWorkTime() {
		return totalWorkTime;
	}
	public void setTotalWorkTime(Timestamp totalWorkTime) {
		this.totalWorkTime = totalWorkTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
