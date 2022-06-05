package com.kbigdata.contactApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kbigdata.contactApp.dto.ContactDto;
import com.kbigdata.contactApp.dto.MemberDto;
import com.kbigdata.contactApp.util.JDBCTemplete;

/**
 * @filename : ContactDao.java 
 * @project : contactApp 
 * @date : 2022. 3. 10.
 * @author : 박다울
 * @version : 1.0
 * @description : Dao 생성
 */
public class ContactDao {
	/**
	 * @methodname : join 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원가입
	 * @return : boolean
	 * @param : memberDto : MemberDto
	 */
	public boolean join(MemberDto memberDto) {
		boolean result = false;
		Connection con 			= null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER(MEMID,PWD,MEMNAME,MEMTEL)" + 
					 "VALUES(?,?,?,?)							  ";
		try {
			con = JDBCTemplete.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDto.getMemid());
			pstmt.setString(2, memberDto.getPwd());
			pstmt.setString(3, memberDto.getMemname());
			pstmt.setString(4, memberDto.getMemtel());
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}//join 종료
	
	/**
	 * @methodname : login 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 로그인
	 * @return : boolean
	 * @param : memberDto : MemberDto
	 */
	public boolean login(MemberDto memberDto) {
		boolean result = false;
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT *		  " + 
					 "FROM 	 MEMBER	  " + 
					 "WHERE  MEMID = ?" + 
					 "	AND  PWD = ?  ";
		try {
			con = JDBCTemplete.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDto.getMemid());
			pstmt.setString(2, memberDto.getPwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}//login 종료
	
	/**
	 * @methodname : memberSearchAll 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원 전체 조회
	 * @return : ArrayList<MemberDto>
	 */
	public ArrayList<MemberDto> memberSearchAll() {
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql =  "SELECT * FROM MEMBER";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMemid(rs.getString("memid"));
				memberDto.setPwd(rs.getString("pwd"));
				memberDto.setMemname(rs.getString("memname"));
				memberDto.setMemtel(rs.getString("memtel"));
				memberDto.setRegdate(rs.getDate("regdate"));
				memberList.add(memberDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt, rs);
		}
		return memberList;
	}//memberSearchAll 종료
	
	/**
	 * @methodname : selectById 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원 아이디로 회원정보 조회
	 * @return : MemberDto
	 * @param : memid : String
	 */
	public MemberDto selectById(String memid) {
		MemberDto memberDto = new MemberDto();
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT *		  " + 
					 "FROM 	MEMBER	  " + 
					 "WHERE MEMID = ? ";
		try {
			con = JDBCTemplete.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto.setMemid(rs.getString("memid"));
				memberDto.setMemname(rs.getString("memname"));
				memberDto.setMemtel(rs.getString("memtel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberDto;
	}//selectById 종료
	
	/**
	 * @methodname : memberUpdate 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 회원정보 수정
	 * @return : void
	 * @param : memberDto : MemberDto
	 */
	public void memberUpdate(MemberDto memberDto) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER " + 
					 "SET PWD=?		" + 
					 "	, MEMTEL=?	" + 
					 "	, MEMNAME=?	" + 
					 "WHERE MEMID=?	";
		try {
			con = JDBCTemplete.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDto.getPwd());
			pstmt.setString(2, memberDto.getMemtel());
			pstmt.setString(3, memberDto.getMemname());
			pstmt.setString(4, memberDto.getMemid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//memberUpdate 종료
	
	/**
	 * @methodname : memberDelete 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : id, pwd 정보가 null인 회원 삭제
	 * @return : void
	 * @param : memberDto : MemberDto
	 */
	public void memberDelete() {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER " + 
					 "WHERE MEMID IS NULL" + 
					 "	AND PWD IS NULL	 ";
		try {
			con = JDBCTemplete.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//memberDelete 종료
	
	/**
	 * @methodname : contactAdd 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 추가
	 * @return : boolean
	 * @param : contactDto : ContactDto
	 */
	public boolean contactAdd(ContactDto contactDto) {
		boolean result = false;
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CONTACT										   " + 
					 "VALUES (													   " + 
					 "	  TO_CHAR(SYSDATE, 'YYYYMM') + TO_CHAR(CONTACT_SEQ.NEXTVAL)" + 
					 "	, ?														   " + 
					 "	, ?														   " + 
					 "	, ?														   " + 
					 "	, ?														   " + 
					 "	)														   ";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contactDto.getContactnm());
			pstmt.setString(2, contactDto.getContactnum());
			pstmt.setString(3, contactDto.getContactaddr());
			pstmt.setString(4, contactDto.getCategoryno());
			
			int rowCnt = pstmt.executeUpdate();
			if(rowCnt > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt);
		}
		return result;  
	}//contactAdd 종료
	
	/**
	 * @methodname : SearchAll 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 전체 조회
	 * @return : ArrayList<ContactDto>
	 */
	public ArrayList<ContactDto> SearchAll() {
		ArrayList<ContactDto> contacts = new ArrayList<ContactDto>();
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT a.CONTACTNO				" + 
					 "	   , a.CONTACTNM				" + 
					 "	   , a.CONTACTNUM				" + 
					 "	   , a.CONTACTADDR				" + 
					 "	   , b.CATEGORYNM				" + 
					 "  FROM CONTACT a					" + 
					 "     , CATEGORY b					" + 
					 " WHERE a.CATEGORYNO = b.CATEGORYNO";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ContactDto contactDto = new ContactDto();
				contactDto.setContactno(rs.getString("contactno"));
				contactDto.setContactnm(rs.getString("contactnm"));
				contactDto.setContactnum(rs.getString("contactnum"));
				contactDto.setContactaddr(rs.getString("contactaddr"));
				contactDto.setCategorynm(rs.getString("categorynm"));
				contacts.add(contactDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt, rs);
		}
		return contacts;
	}//SearchAll 종료
	
	/**
	 * @methodname : searchByName 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 이름 검색
	 * @return : ContactDto
	 * @param : name : String
	 */
	public ContactDto searchByName(String contactnm) {
		ContactDto contactDto = new ContactDto();
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT a.CONTACTNO					  " + 
					 "	   , a.CONTACTNM					  " + 
					 "	   , a.CONTACTNUM					  " + 
					 "	   , a.CONTACTADDR					  " + 
					 "	   , b.CATEGORYNM					  " + 
					 "  FROM CONTACT a						  " + 
					 "     , CATEGORY b						  " + 
					 " WHERE a.CATEGORYNO = b.CATEGORYNO	  " + 
					 "	 AND a.CONTACTNM LIKE '%' || ? || '%' ";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contactnm);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				contactDto.setContactno(rs.getString("contactno"));
				contactDto.setContactnm(rs.getString("contactnm"));
				contactDto.setContactnum(rs.getString("contactnum"));
				contactDto.setContactaddr(rs.getString("contactaddr"));
				contactDto.setCategorynm(rs.getString("categorynm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt, rs);
		}
		return contactDto;
	}//searchByName 종료
	
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
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT a.CONTACTNO				 " + 
					 "	   , a.CONTACTNM				 " + 
					 "	   , a.CONTACTNUM				 " + 
					 "	   , a.CONTACTADDR				 " + 
					 "	   , b.CATEGORYNM				 " + 
					 "  FROM CONTACT a					 " + 
					 "     , CATEGORY b					 " + 
					 " WHERE a.CATEGORYNO = b.CATEGORYNO " + 
					 "	 AND a.CONTACTNO=? 				 ";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contactno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				contactDto.setContactno(rs.getString("contactno"));
				contactDto.setContactnm(rs.getString("contactnm"));
				contactDto.setContactnum(rs.getString("contactnum"));
				contactDto.setContactaddr(rs.getString("contactaddr"));
				contactDto.setCategorynm(rs.getString("categorynm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt, rs);
		}
		return contactDto;
	}//searchByContactno 종료
	
	/**
	 * @methodname : contactUpdate 
	 * @date : 2022. 3. 11.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 수정
	 * @return : void
	 * @param : contactDto : ContactDto
	 */
	public void contactUpdate(ContactDto contactDto) {
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CONTACT   " + 
					 "SET CONTACTNM=?  " + 
					 "	, CONTACTNUM=? " + 
					 "	, CONTACTADDR=?" + 
					 "	, CATEGORYNO=? " + 
					 "WHERE CONTACTNO=?";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contactDto.getContactnm());
			pstmt.setString(2, contactDto.getContactnum());
			pstmt.setString(3, contactDto.getContactaddr());
			pstmt.setString(4, contactDto.getCategoryno());
			pstmt.setString(5, contactDto.getContactno());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt);
		}
	}//contactUpdate 종료
	
	/**
	 * @methodname : deleteContact 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : 연락처 삭제
	 * @return : boolean
	 * @param : contactDto : ContactDto
	 */
	public boolean deleteContact(ContactDto contactDto) {
		boolean result = false;
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		String sql = "DELETE			  " + 
					 "  FROM CONTACT	  " + 
					 " WHERE CONTACTNO = ?";
		try {
			conn = JDBCTemplete.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contactDto.getContactno());
			
			int rowCnt = pstmt.executeUpdate();
			if(rowCnt > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn, pstmt);
		}
		return result;  
	}//deleteContact 종료
	
} //클래스 종료
