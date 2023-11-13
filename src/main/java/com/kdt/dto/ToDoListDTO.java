package com.kdt.dto;

import java.sql.Timestamp;

public class ToDoListDTO {
	private int seq;
	private String id;
	private String bgimg;
	private String title;
	private String workspace;
	private boolean bookmark;
	private Timestamp make_date;
	public ToDoListDTO(int seq, String id, String bgimg, String title, String workspace, boolean bookmark,
			Timestamp make_date) {
		super();
		this.seq = seq;
		this.id = id;
		this.bgimg = bgimg;
		this.title = title;
		this.workspace = workspace;
		this.bookmark = bookmark;
		this.make_date = make_date;
	}
	public ToDoListDTO() {
		super();
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
	public String getBgimg() {
		return bgimg;
	}
	public void setBgimg(String bgimg) {
		this.bgimg = bgimg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkspace() {
		return workspace;
	}
	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}
	public boolean isBookmark() {
		return bookmark;
	}
	public void setBookmark(boolean bookmark) {
		this.bookmark = bookmark;
	}
	public Timestamp getMake_date() {
		return make_date;
	}
	public void setMake_date(Timestamp make_date) {
		this.make_date = make_date;
	}
	
}
