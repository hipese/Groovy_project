package com.kdt.dto;

public class ChattingRoomDTO {

	private int seq;
	private String room_name;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public ChattingRoomDTO(int seq, String room_name) {
		super();
		this.seq = seq;
		this.room_name = room_name;
	}
	public ChattingRoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
