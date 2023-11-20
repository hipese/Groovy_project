package com.kdt.dto;

public class Re_MemberDTO {

	private String name;
	private String group_name;
	private String position;
	private String email;
	
	public Re_MemberDTO() {
		super();
	}
	public Re_MemberDTO(String name, String group_name, String position, String email) {
		super();
		this.name = name;
		this.group_name = group_name;
		this.position = position;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
