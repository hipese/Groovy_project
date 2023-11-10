package com.kdt.dto;

public class RoomProfileDTO {

	private int room_seq;
	private String profile_image;
	public int getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(int room_seq) {
		this.room_seq = room_seq;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public RoomProfileDTO(int room_seq, String profile_image) {
		super();
		this.room_seq = room_seq;
		this.profile_image = profile_image;
	}
	public RoomProfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
