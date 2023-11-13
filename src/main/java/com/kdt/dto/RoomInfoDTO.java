package com.kdt.dto;

public class RoomInfoDTO {

	private int seq;
	private String room_name;
	private boolean is_read;
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
	public boolean isIs_read() {
		return is_read;
	}
	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}
	public RoomInfoDTO(int seq, String room_name, boolean is_read) {
		super();
		this.seq = seq;
		this.room_name = room_name;
		this.is_read = is_read;
	}
	public RoomInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
