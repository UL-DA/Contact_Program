package com.kbigdata.contactApp.dto;

import java.sql.Date;

public class MemberDto {
	private String memid;  //회원 아이디
	private String pwd;	   //회원 비밀번호
	private String memname;//회원 이름
	private String memtel; //회원 전호번호
	private Date regdate;  //회원 가입일
	
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getMemtel() {
		return memtel;
	}
	public void setMemtel(String memtel) {
		this.memtel = memtel;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "MemberDto [memid=" + memid + ", pwd=" + pwd + ", memname=" + memname + ", memtel=" + memtel
				+ ", regdate=" + regdate + "]";
	}
	
}
