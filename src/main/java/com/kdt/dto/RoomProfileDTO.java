package com.kdt.dto;

public class RoomProfileDTO {

	private int room_seq;
	private String id;
	private String name;
	private String profile_image;
	public int getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(int room_seq) {
		this.room_seq = room_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public RoomProfileDTO(int room_seq, String id, String name, String profile_image) {
		super();
		this.room_seq = room_seq;
		this.id = id;
		this.name = name;
		this.profile_image = profile_image;
	}
	public RoomProfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
