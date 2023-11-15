package com.kdt.dto;

import java.sql.Timestamp;

public class DeptReplyDTO {

	private int seq;
	private int parent_seq;
	private String writer;
	private String contents;
	private Timestamp write_date;

	public DeptReplyDTO(int seq, int parent_seq, String writer, String contents, Timestamp write_date) {
		super();
		this.seq = seq;
		this.parent_seq = parent_seq;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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

	public DeptReplyDTO() {}
}
