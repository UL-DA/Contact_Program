package com.kbigdata.contactApp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kbigdata.contactApp.dto.ContactDto;
import com.kbigdata.contactApp.dto.MemberDto;
import com.kbigdata.contactApp.service.ContactService;

/**
 * Servlet implementation class ContactUpdateServlet
 */
@WebServlet("/ContactUpdateServlet")
public class ContactUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.getAttribute("memid");
		String memid = (String)session.getAttribute("memid");
		String contactno = request.getParameter("contactno");
		
		ContactService contactService = new ContactService();
		MemberDto memberDto = contactService.selectById(memid);
		ContactDto contactDto = new ContactDto();
		contactDto.setContactno(contactno);
		contactDto = contactService.searchByContactno(contactno);
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("contactDto", contactDto);
		RequestDispatcher disp = request.getRequestDispatcher("contactUpdate.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String memid 	   = request.getParameter("memid");
		String contactnm   = request.getParameter("contactnm");
		String contactnum  = request.getParameter("contactnum");
		String contactaddr = request.getParameter("contactaddr");
		String contactno   = request.getParameter("contactno");
		String categoryno  = request.getParameter("categoryno");
		
		ContactDto contactDto = new ContactDto();
		contactDto.setContactnm(contactnm);
		contactDto.setContactnum(contactnum);
		contactDto.setContactaddr(contactaddr);
		contactDto.setContactno(contactno);
		contactDto.setCategoryno(categoryno);
		
		HttpSession session = request.getSession();
		session.getAttribute("memid");
		String memid = (String)session.getAttribute("memid");
		
		ContactService contactService = new ContactService();
		contactService.contactUpdate(contactDto);
		MemberDto memberDto = contactService.selectById(memid);
		ArrayList<MemberDto> memberList = contactService.memberSearchAll();
		request.setAttribute("memberList", memberList);
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("contactDto", contactDto);
		RequestDispatcher disp = request.getRequestDispatcher("ContactSearchAllServlet");
		disp.forward(request, response);
	}

}
