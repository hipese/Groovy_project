package com.kdt.dto;

import java.sql.Timestamp;

public class Sign_documentDTO {
	private int seq;
	private String writer;
	private String document_type;
	private String recipient;
	private String title;
	private String contents;
	private String ori_name;
	private String sys_name;
	private int accept;
	private Timestamp write_date;
	private String comment;
	
	
	public Sign_documentDTO() {};
	
	
	public Sign_documentDTO(int seq, String writer, String document_type, String recipient, String title,
			String contents, String ori_name, String sys_name, int accept, Timestamp write_date, String comment) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.document_type = document_type;
		this.recipient = recipient;
		this.title = title;
		this.contents = contents;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
		this.accept = accept;
		this.write_date = write_date;
		this.comment = comment;
	}
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
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
	public int getAccept() {
		return accept;
	}
	public void setAccept(int accept) {
		this.accept = accept;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
