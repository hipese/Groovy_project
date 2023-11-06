package com.kdt.dto;

public class favoriteDTO {
	
	private String id;
	private String target_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTarget_id() {
		return target_id;
	}
	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}
	public favoriteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public favoriteDTO(String id, String target_id) {
		super();
		this.id = id;
		this.target_id = target_id;
	}
	
}
