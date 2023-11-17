package com.kdt.dto;

public class TDLTitleDTO {
	private int seq;
	private String id;
	private String title;
	private int parent_seq;
	public TDLTitleDTO() {
		super();
	}
	public TDLTitleDTO(int seq, String id, String title, int parent_seq) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.parent_seq = parent_seq;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
	
}
