package com.kdt.dto;

public class Sign_MembersIDDTO {
	private String writerID;
	private String receiverID;
	
	
	
	public Sign_MembersIDDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sign_MembersIDDTO(String writerID, String receiverID) {
		super();
		this.writerID = writerID;
		this.receiverID = receiverID;
	}
	public String getWriterID() {
		return writerID;
	}
	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}
	public String getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	
	
}
