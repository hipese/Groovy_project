package com.kdt.dto;

import java.sql.Timestamp;

public class ProjectDTO {
	
	private int pseq;
	private String pmanager;
	private String pname;
	private String pcontents;
	private Timestamp ptime_limit;
	public ProjectDTO() {
		super();
	}
	public ProjectDTO(int pseq, String pmanager, String pname, String pcontents, Timestamp ptime_limit) {
		super();
		this.pseq = pseq;
		this.pmanager = pmanager;
		this.pname = pname;
		this.pcontents = pcontents;
		this.ptime_limit = ptime_limit;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getPmanager() {
		return pmanager;
	}
	public void setPmanager(String pmanager) {
		this.pmanager = pmanager;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontents() {
		return pcontents;
	}
	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}
	public Timestamp getPtime_limit() {
		return ptime_limit;
	}
	public void setPtime_limit(Timestamp ptime_limit) {
		this.ptime_limit = ptime_limit;
	}
	
	

}
