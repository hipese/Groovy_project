package com.kdt.dto;

public class ProjectMemberDTO {

	private int pmember_seq;
	private int pseq;
	private String group_name;
	private String name;
	private String id;
	
	public ProjectMemberDTO() {
		super();
	}
	public ProjectMemberDTO(int pmember_seq, int pseq, String group_name, String id) {
		super();
		this.pmember_seq = pmember_seq;
		this.pseq = pseq;
		this.group_name = group_name;
		this.id = id;
	}
	
	public ProjectMemberDTO(int pseq, String group_name, String name, String id) {
		super();
		this.pseq = pseq;
		this.group_name = group_name;
		this.name = name;
		this.id = id;
	}
	public int getPmember_seq() {
		return pmember_seq;
	}
	public void setPmember_seq(int pmember_seq) {
		this.pmember_seq = pmember_seq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
