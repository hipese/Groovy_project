package com.kdt.dto;

import java.sql.Timestamp;

public class Realtime_NotificationsDTO {
	private int seq;
	private String recipient;
	private String contents;
	private Timestamp write_date;
	private boolean read_status;
	private int parent_seq;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
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
	public boolean isRead_status() {
		return read_status;
	}
	public void setRead_status(boolean read_status) {
		this.read_status = read_status;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public Realtime_NotificationsDTO(int seq, String recipient, String contents, Timestamp write_date,
			boolean read_status, int parent_seq) {
		super();
		this.seq = seq;
		this.recipient = recipient;
		this.contents = contents;
		this.write_date = write_date;
		this.read_status = read_status;
		this.parent_seq = parent_seq;
	}
	public Realtime_NotificationsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
