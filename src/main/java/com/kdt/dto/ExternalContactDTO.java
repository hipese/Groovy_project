package com.kdt.dto;

public class ExternalContactDTO {
	private int seq;
	private String company;
	private String name;
	private String group_name;
	private String position;
	private String contact;
	private String email;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public ExternalContactDTO(int seq, String company, String name, String group_name, String position, String contact,
			String email) {
		super();
		this.seq = seq;
		this.company = company;
		this.name = name;
		this.group_name = group_name;
		this.position = position;
		this.contact = contact;
		this.email = email;
	}
	public ExternalContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
