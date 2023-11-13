package com.kdt.dto;

public class DeptBoard_FileDTO {
	private int seq;
	private int parent_seq;
	private String ori_name;
	private String sys_name;
	private String file_size;
	
	public DeptBoard_FileDTO(int seq, int parent_seq, String ori_name, String sys_name, String file_size) {
		super();
		this.seq = seq;
		this.parent_seq = parent_seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
		this.file_size = file_size;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getParent_seq() {
		return parent_seq;
	}

	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}

	public String getOri_name() {
		return ori_name;
	}

	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	public DeptBoard_FileDTO() {}
}
