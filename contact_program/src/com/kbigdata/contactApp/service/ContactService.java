package com.kbigdata.contactApp.service;

import java.util.ArrayList;

import com.kbigdata.contactApp.dao.ContactDao;
import com.kbigdata.contactApp.dto.ContactDto;
import com.kbigdata.contactApp.dto.MemberDto;

/**
 * @filename : ContactService.java 
 * @project : contactApp 
 * @date : 2022. 3. 11.
 * @author : 박다울 
 * @version : 1.0
 * @description : ContactService 생성
 */
public class ContactService {
	
	/**
	 * @methodname : login 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원 로그인 
	 * @return : boolean
	 * @param : memberDto : MemberDto
	 */
	public boolean login(MemberDto memberDto) {
		boolean result = true;
		ContactDao contactDao = new ContactDao();
		result = contactDao.login(memberDto);
		return result;
	}
	
	/**
	 * @methodname : join 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원가입
	 * @return : boolean
	 * @param : memberDto : MemberDto
	 */
	public boolean join(MemberDto memberDto) {
		boolean result = true;
		ContactDao contactDao = new ContactDao();
		result = contactDao.join(memberDto);
		return result;
	}
	
	/**
	 * @methodname : memberSearchAll 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원 전체 조회
	 * @return : ArrayList<MemberDto>
	 */
	public ArrayList<MemberDto> memberSearchAll() {
		ContactDao contactDao = new ContactDao();
		ArrayList<MemberDto> memberList = contactDao.memberSearchAll();
		return memberList;
	}//memberSearchAll 종료
	
	/**
	 * @methodname : selectById 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 아이디로 회원검색
	 * @return : MemberDto
	 * @param : memid : String
	 */
	public MemberDto selectById(String memid) {
		MemberDto memberDto = new MemberDto();
		ContactDao contactDao = new ContactDao();
		memberDto = contactDao.selectById(memid);
		return memberDto;
	}
	
	/**
	 * @methodname : memberUpdate 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원정보 수정
	 * @return : void
	 * @param : memberDto : MemberDto
	 */
	public void memberUpdate(MemberDto memberDto) {
		ContactDao contactDao = new ContactDao();
		contactDao.memberUpdate(memberDto);
	}
	
	/**
	 * @methodname : memberDelete 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : id, pwd 정보가 null인 회원 삭제
	 * @return : void
	 * @param : memberDto : MemberDto
	 */
	public void memberDelete() {
		ContactDao contactDao = new ContactDao();
		contactDao.memberDelete();
	}
	
	/**
	 * @methodname : contactAdd 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 추가
	 * @return : boolean
	 * @param : contactDto : ContactDto
	 */
	public boolean contactAdd(ContactDto contactDto) {
		boolean result = false;
		ContactDao contactDao = new ContactDao();
		result = contactDao.contactAdd(contactDto);
		return result;
	}//contactAdd 종료
	
	/**
	 * @methodname : searchAll 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 전체 조회
	 * @return : ContactDto
	 */
	public ArrayList<ContactDto> searchAll() {
		ContactDao contactDao = new ContactDao();
		ArrayList<ContactDto> contacts = contactDao.SearchAll();
		return contacts;
	}//searchAll 종료
	
	/**
	 * @methodname : searchByContactno 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 식별번호로 정보 조회 
	 * @return : ContactDto
	 * @param : contactno : String
	 */
	public ContactDto searchByContactno(String contactno) {
		ContactDto contactDto = new ContactDto();
		ContactDao contactDao = new ContactDao();
		contactDto = contactDao.searchByContactno(contactno);
		return contactDto;
	}//searchByName 종료
	
	/**
	 * @methodname : searchByName 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 이름 검색 
	 * @return : ContactDto
	 * @param : contactnm : String
	 */
	public ContactDto searchByName(String contactnm) {
		ContactDto contactDto = new ContactDto();
		ContactDao contactDao = new ContactDao();
		contactDto = contactDao.searchByName(contactnm);
		return contactDto;
	}//searchByName 종료
	
	/**
	 * @methodname : contactUpdate 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 정보 수정
	 * @return : void
	 * @param : contactDto : ContactDto
	 */
	public void contactUpdate(ContactDto contactDto) {
		ContactDao contactDao = new ContactDao();
		contactDao.contactUpdate(contactDto);
	}//contactUpdate 종료
	
	/**
	 * @methodname : deleteContact 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 삭제
	 * @return : void
	 * @param : contactDto : ContactDto
	 */
	public void deleteContact(ContactDto contactDto) {
		ContactDao contactDao = new ContactDao();
		contactDao.deleteContact(contactDto);
	}//deleteContact 종료
	
}//클래스 종료
