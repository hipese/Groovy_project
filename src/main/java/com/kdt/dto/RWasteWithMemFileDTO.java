package com.kdt.dto;

import java.sql.Timestamp;

public class RWasteWithMemFileDTO {


	private String sender;
	private String receipient;
	private String title;
	private Timestamp write_date;
	private boolean is_read;
	private int wr_seq;
	private int parent_seq;
	private String member_id;
	private String name;
	private String group_name;
	private String position;
	private String email;
	private int mfseq;
	private int fparent_seq;
	private String ori_name;
	private String sys_name;

	public RWasteWithMemFileDTO(String sender, String receipient, String title, Timestamp write_date, boolean is_read,
			int wr_seq, int parent_seq, String member_id, String name, String group_name, String position, String email,
			int mfseq, int fparent_seq, String ori_name, String sys_name) {
		super();
		this.sender = sender;
		this.receipient = receipient;
		this.title = title;
		this.write_date = write_date;
		this.is_read = is_read;
		this.wr_seq = wr_seq;
		this.parent_seq = parent_seq;
		this.member_id = member_id;
		this.name = name;
		this.group_name = group_name;
		this.position = position;
		this.email = email;
		this.mfseq = mfseq;
		this.fparent_seq = fparent_seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String receipient) {
		this.receipient = receipient;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	public boolean isIs_read() {
		return is_read;
	}

	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}

	public int getWr_seq() {
		return wr_seq;
	}

	public void setWr_seq(int wr_seq) {
		this.wr_seq = wr_seq;
	}

	public int getParent_seq() {
		return parent_seq;
	}

	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public RWasteWithMemFileDTO() {
		super();
	}
	
}
