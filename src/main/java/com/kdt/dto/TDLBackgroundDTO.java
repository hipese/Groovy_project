package com.kdt.dto;

public class TDLBackgroundDTO {
	private int seq;
	private String id;
	private String bgselect;
	private int parent_seq;
	public TDLBackgroundDTO(int seq, String id, String bgselect, int parent_seq) {
		super();
		this.seq = seq;
		this.id = id;
		this.bgselect = bgselect;
		this.parent_seq = parent_seq;
	}
	public TDLBackgroundDTO() {
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
	public String getBgselect() {
		return bgselect;
	}
	public void setBgselect(String bgselect) {
		this.bgselect = bgselect;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
	
}
