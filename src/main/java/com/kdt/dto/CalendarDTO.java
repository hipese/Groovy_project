package com.kdt.dto;

import java.sql.Timestamp;

public class CalendarDTO {
	private int seq;
	private String id;
	private String project;
	private String title;
	private String starttime;
	private String endtime;
	private String contents;
	private Timestamp write_date;
	public CalendarDTO() {
		super();
	}
	public CalendarDTO(int seq, String id, String project, String title, String starttime, String endtime,
			String contents, Timestamp write_date) {
		super();
		this.seq = seq;
		this.id = id;
		this.project = project;
		this.title = title;
		this.starttime = starttime;
		this.endtime = endtime;
		this.contents = contents;
		this.write_date = write_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	
}
