package com.kdt.dto;

public class SearchTermDTO {
	private String name;
	private String position;
	private String group_name;
	private String id;
	

	
	public SearchTermDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchTermDTO(String name, String position, String group_name, String id) {
		super();
		this.name = name;
		this.position = position;
		this.group_name = group_name;
		this.id = id;
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
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
