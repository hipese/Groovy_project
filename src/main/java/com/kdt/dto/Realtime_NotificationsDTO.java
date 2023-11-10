package com.kdt.dto;

import java.sql.Timestamp;

public class Realtime_NotificationsDTO {
	private int seq;
	private String recipient;
	private String contents;
	private Timestamp write_date;
	private boolean read_status;
	
	public Realtime_NotificationsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Realtime_NotificationsDTO(int seq, String recipient, String contents, Timestamp write_date,
			boolean read_status) {
		super();
		this.seq = seq;
		this.recipient = recipient;
		this.contents = contents;
		this.write_date = write_date;
		this.read_status = read_status;
	}
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
}
