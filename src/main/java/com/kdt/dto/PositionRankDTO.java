package com.kdt.dto;

public class PositionRankDTO {
	private String position;
	private int Ranks;
	
	public PositionRankDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PositionRankDTO(String position, int ranks) {
		super();
		this.position = position;
		Ranks = ranks;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getRanks() {
		return Ranks;
	}
	public void setRanks(int ranks) {
		Ranks = ranks;
	}
	
	
}
