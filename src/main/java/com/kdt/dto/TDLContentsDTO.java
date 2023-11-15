package com.kdt.dto;

public class TDLContentsDTO {
	private int seq;
	private String id;
	private String contents;
	private int parent_seq;
	public TDLContentsDTO(int seq, String id, String contents, int parent_seq) {
		super();
		this.seq = seq;
		this.id = id;
		this.contents = contents;
		this.parent_seq = parent_seq;
	}
	public TDLContentsDTO() {
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
	
}
