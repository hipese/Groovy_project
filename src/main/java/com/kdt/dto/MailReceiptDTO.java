package com.kdt.dto;

public class MailReceiptDTO {

	private int seq;
	private int parent_seq;
	private String sender;
	private String receipient;
	private boolean is_read;
	private boolean is_delete;
	private boolean is_mark;

	public MailReceiptDTO(int seq, int parent_seq, String sender, String receipient, boolean is_read, boolean is_delete,
			boolean is_mark) {
		super();
		this.seq = seq;
		this.parent_seq = parent_seq;
		this.sender = sender;
		this.receipient = receipient;
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
