package com.kdt.dto;

public class ContactDTO {
	
	private String id;
	private String group_name;
	private String name;
	private String position;
	private String contact;
	private String email;
	private String profile_image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public ContactDTO(String id, String group_name, String name, String position, String contact, String email,
			String profile_image) {
		super();
		this.id = id;
		this.group_name = group_name;
		this.name = name;
		this.position = position;
		this.contact = contact;
		this.email = email;
		this.profile_image = profile_image;
	}
	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
