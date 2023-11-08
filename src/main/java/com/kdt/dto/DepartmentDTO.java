package com.kdt.dto;

public class DepartmentDTO {
	private int dept_code;
	private String group_name;
	
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DepartmentDTO(int dept_code, String group_name) {
		super();
		this.dept_code = dept_code;
		this.group_name = group_name;
	}
	public int getDept_code() {
		return dept_code;
	}
	public void setDept_code(int dept_code) {
		this.dept_code = dept_code;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
}
