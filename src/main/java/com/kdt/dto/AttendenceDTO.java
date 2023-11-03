package com.kdt.dto;

import java.sql.Timestamp;

public class AttendenceDTO {

	private int attendanceid;
	private String id;
	private Timestamp workstart;
	private Timestamp workend;
	private Timestamp overendtime;
	public AttendenceDTO() {
		super();
	}
	public AttendenceDTO(int attendanceid, String id, Timestamp workstart, Timestamp workend, Timestamp overendtime) {
		super();
		this.attendanceid = attendanceid;
		this.id = id;
		this.workstart = workstart;
		this.workend = workend;
		this.overendtime = overendtime;
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
	
	
	
}
