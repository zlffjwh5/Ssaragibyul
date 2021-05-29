package com.ssaragibyul.point.domain;

public class PointAndProject extends Point{
	//포인트
	//펀딩성공 + 펀딩제목 + 펀딩번호
	//기부성공 + 기부제목 + 기부번호
	
	private String subject; //펀딩,기부 제목
	//private int successNo; //펀딩, 기부 프로젝트 번호
	private int projectNo;
	private String nickName; //oppUserId의 닉네임
	
	public PointAndProject() {}

	public PointAndProject(String subject, int projectNo, String nickName) {
		super();
		this.subject = subject;
		this.projectNo = projectNo;
		this.nickName = nickName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "PointAndProject [subject=" + subject + ", projectNo=" + projectNo + ", nickName=" + nickName
				+ ", getPntListNo()=" + getPntListNo() + ", getEventNo()=" + getEventNo() + ", getEventNoCharge()="
				+ getEventNoCharge() + ", getUserId()=" + getUserId() + ", getOppUserId()=" + getOppUserId()
				+ ", getVarTime()=" + getVarTime() + ", getEventCode()=" + getEventCode() + ", getVarType()="
				+ getVarType() + ", getVarAmount()=" + getVarAmount() + ", getBuyerEmail()=" + getBuyerEmail()
				+ ", getReceiptUrl()=" + getReceiptUrl() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
