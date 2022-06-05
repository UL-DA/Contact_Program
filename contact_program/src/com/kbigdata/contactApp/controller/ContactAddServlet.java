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
 * Servlet implementation class ContactAddServlet
 */
@WebServlet("/ContactAddServlet")
public class ContactAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAddServlet() {
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
		
		ContactService contactService = new ContactService();
		MemberDto memberDto = contactService.selectById(memid);
		ArrayList<MemberDto> memberList = contactService.memberSearchAll();
		request.setAttribute("memberList", memberList);
		request.setAttribute("memberDto", memberDto);
		RequestDispatcher disp = request.getRequestDispatcher("contactAdd.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String contactnm   = request.getParameter("contactnm");
		String contactnum  = request.getParameter("contactnum");
		String contactaddr = request.getParameter("contactaddr");
		String categoryno  = request.getParameter("categoryno");
		
		ContactDto contactDto = new ContactDto();
		contactDto.setContactnm(contactnm);
		contactDto.setContactnum(contactnum);
		contactDto.setContactaddr(contactaddr);
		contactDto.setCategoryno(categoryno);
		
		ContactService contactService = new ContactService();
		contactService.contactAdd(contactDto);
		
		HttpSession session = request.getSession(true);
		String memid = (String)session.getAttribute("memid");
		session.setAttribute("memid", memid);
		
		MemberDto memberDto = contactService.selectById(memid);
		ArrayList<MemberDto> memberList = contactService.memberSearchAll();
		request.setAttribute("memberList", memberList);
		request.setAttribute("memberDto", memberDto);
		RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
		disp.forward(request, response);
	}

}
