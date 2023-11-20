package com.kdt.dto;

import java.sql.Timestamp;

public class MailWithMemberDTO {

	private int seq;
	private int parent_seq;
	private String sender;
	private String receipient;
	private String title;
	private String contents;
	private Timestamp write_date;
	private boolean is_read;
	private boolean is_delete;
	private boolean is_mark;
	private String name;
	private String group_name;
	private String position;
	private String email;
	private int mfseq;
	private int fparent_seq;
	private String ori_name;
	private String sys_name;
	
	public MailWithMemberDTO() {
		super();
	}
	public MailWithMemberDTO(int seq, int parent_seq, String sender, String receipient, String title, String contents,
			Timestamp write_date, boolean is_read, boolean is_delete, boolean is_mark, String name, String group_name,
			String position, String email, int mfseq, int fparent_seq, String ori_name, String sys_name) {
		super();
		this.seq = seq;
		this.parent_seq = parent_seq;
		this.sender = sender;
		this.receipient = receipient;
		this.title = title;
		this.contents = contents;
		this.write_date = write_date;
		this.is_read = is_read;
		this.is_delete = is_delete;
		this.is_mark = is_mark;
		this.name = name;
		this.group_name = group_name;
		this.position = position;
		this.email = email;
		this.mfseq = mfseq;
		this.fparent_seq = fparent_seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	public boolean isIs_mark() {
		return is_mark;
	}
	public void setIs_mark(boolean is_mark) {
		this.is_mark = is_mark;
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
	
}
