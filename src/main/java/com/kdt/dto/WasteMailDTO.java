package com.kdt.dto;

public class WasteMailDTO {
	private int ws_seq;
	private int parent_seq;
	private String member_id;
	
	public WasteMailDTO() {
		super();
	}
	
	public WasteMailDTO(int ws_seq, int parent_seq, String member_id) {
		super();
		this.ws_seq = ws_seq;
		this.parent_seq = parent_seq;
		this.member_id = member_id;
	}
	
	public int getWs_seq() {
		return ws_seq;
	}
	public void setWs_seq(int ws_seq) {
		this.ws_seq = ws_seq;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
}
