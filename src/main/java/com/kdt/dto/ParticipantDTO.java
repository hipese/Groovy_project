package com.kdt.dto;

public class ParticipantDTO {

	private int room_seq;
	private String user_id;
	private boolean is_read;
	public int getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(int room_seq) {
		this.room_seq = room_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isIs_read() {
		return is_read;
	}
	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}
	public ParticipantDTO(int room_seq, String user_id, boolean is_read) {
		super();
		this.room_seq = room_seq;
		this.user_id = user_id;
		this.is_read = is_read;
	}
	public ParticipantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
