package com.kdt.dto;

public class VacationBalancesDTO {
	private int balanceID;
	private String memberID;
	private int year;
	private int totalAnnualEntitlement; // 휴가 일수
	private int usedDays; //사용 휴가
	private int remainingDays; //남은 휴가
	
	
	public VacationBalancesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacationBalancesDTO(int balanceID, String memberID, int year, int totalAnnualEntitlement, int usedDays,
			int remainingDays) {
		super();
		this.balanceID = balanceID;
		this.memberID = memberID;
		this.year = year;
		this.totalAnnualEntitlement = totalAnnualEntitlement;
		this.usedDays = usedDays;
		this.remainingDays = remainingDays;
	}
	
	public int getBalanceID() {
		return balanceID;
	}
	public void setBalanceID(int balanceID) {
		this.balanceID = balanceID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTotalAnnualEntitlement() {
		return totalAnnualEntitlement;
	}
	public void setTotalAnnualEntitlement(int totalAnnualEntitlement) {
		this.totalAnnualEntitlement = totalAnnualEntitlement;
	}
	public int getUsedDays() {
		return usedDays;
	}
	public void setUsedDays(int usedDays) {
		this.usedDays = usedDays;
	}
	public int getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}
}
