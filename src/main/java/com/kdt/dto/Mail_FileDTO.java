package com.kdt.dto;

public class Mail_FileDTO {
	private int mfseq;
	private int fparent_seq;
	private String ori_name;
	private String sys_name;
	
	public Mail_FileDTO(int mfseq, int fparent_seq, String ori_name, String sys_name) {
		super();
		this.mfseq = mfseq;
		this.fparent_seq = fparent_seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
	}

	public int getMfseq() {
		return mfseq;
	}

	public void setMfseq(int mfseq) {
		this.mfseq = mfseq;
	}

	public int getFparent_seq() {
		return fparent_seq;
	}

	public void setFparent_seq(int fparent_seq) {
		this.fparent_seq = fparent_seq;
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

	public Mail_FileDTO() {}
}
