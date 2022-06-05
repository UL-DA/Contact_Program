package com.kbigdata.contactApp.dto;

public class ContactDto {
	
	/**
	 * @작성자 : 박다울
	 * @파일이름 : ContactDto.java 
	 * @프로젝트 : contactApp 
	 * @개발일자 : 2022. 3. 10.
	 * @변경이력 : 1.0
	 * @프로그램설명 : ContactDto 변수 및 기능 생성
	 */
	private String contactno;  //연락처 식별번호
	private String contactnm;  //연락처 이름
	private String contactnum; //연락처 전화번호
	private String contactaddr;//연락처 주소
	private String categoryno; //구분 번호
	private String categorynm; //구분 이름
	
	/**
	 * @methodname : getter, setter 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : getter, setter 생성
	 * @return : String
	 */
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getContactnm() {
		return contactnm;
	}
	public void setContactnm(String contactnm) {
		this.contactnm = contactnm;
	}
	public String getContactnum() {
		return contactnum;
	}
	public void setContactnum(String contactnum) {
		this.contactnum = contactnum;
	}
	public String getContactaddr() {
		return contactaddr;
	}
	public void setContactaddr(String contactaddr) {
		this.contactaddr = contactaddr;
	}
	public String getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(String categoryno) {
		this.categoryno = categoryno;
	}
	public String getCategorynm() {
		return categorynm;
	}
	public void setCategorynm(String categorynm) {
		this.categorynm = categorynm;
	}

	/**
	 * @methodname : toString 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 출력 양식 지정
	 * @return : String
	 */
	@Override
	public String toString() {
		return "회원 정보 : [이름=" + contactnm + ", 연락처=" + contactnum 
				+ ", 주소=" + contactaddr + ", 구분=" + categorynm + ", 식별번호=" + contactno+ "]";
	}	
	
}// 클래스 종료
