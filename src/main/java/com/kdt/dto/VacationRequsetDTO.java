package com.kdt.dto;

public class VacationRequsetDTO {
	private String memberID;
    private int amount;
    
	public VacationRequsetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacationRequsetDTO(String memberID, int amount) {
		super();
		this.memberID = memberID;
		this.amount = amount;
	}
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
    
   
}
