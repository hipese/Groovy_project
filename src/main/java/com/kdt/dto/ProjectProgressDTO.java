package com.kdt.dto;

public class ProjectProgressDTO {

	private String state;
	private int count;
	public ProjectProgressDTO() {
		super();
	}
	public ProjectProgressDTO(String state, int count) {
		super();
		this.state = state;
		this.count = count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
