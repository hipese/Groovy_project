package com.kdt.dto;

import java.sql.Timestamp;

public class MessageDTO {
	private int seq;
	private String id;
	private int room_seq;
	private String contents;
	private Timestamp write_time;
	private boolean is_file;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(int room_seq) {
		this.room_seq = room_seq;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Timestamp write_time) {
		this.write_time = write_time;
	}
	public boolean isIs_file() {
		return is_file;
	}
	public void setIs_file(boolean is_file) {
		this.is_file = is_file;
	}
	public MessageDTO(int seq, String id, int room_seq, String contents, Timestamp write_time, boolean is_file) {
		super();
		this.seq = seq;
		this.id = id;
		this.room_seq = room_seq;
		this.contents = contents;
		this.write_time = write_time;
		this.is_file = is_file;
	}
	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
