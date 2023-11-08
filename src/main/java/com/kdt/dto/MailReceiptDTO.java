package com.kdt.dto;

import java.sql.Timestamp;

public class MailReceiptDTO {

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

	public MailReceiptDTO(int seq, int parent_seq, String sender, String receipient, String title, String contents,
			Timestamp write_date, boolean is_read, boolean is_delete, boolean is_mark) {
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

	public MailReceiptDTO() {}
}
