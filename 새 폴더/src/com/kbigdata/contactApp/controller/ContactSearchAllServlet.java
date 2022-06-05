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
 * Servlet implementation class ContactSearchAllServlet
 */
@WebServlet("/ContactSearchAllServlet")
public class ContactSearchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactSearchAllServlet() {
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
		ArrayList<ContactDto> contacts  = contactService.searchAll();
		request.setAttribute("memberList", memberList);
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("contacts", contacts);
		RequestDispatcher disp = request.getRequestDispatcher("contactSearchAll.jsp");
		disp.forward(request, response);
		response.sendRedirect("contactSearchAll.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.getAttribute("memid");
		String memid = (String)session.getAttribute("memid");
		
		ContactService contactService = new ContactService();
		MemberDto memberDto = new MemberDto();
		
		memid = request.getParameter("memid");
		String pwd	 = request.getParameter("pwd");
		memberDto.setMemid(memid);
		memberDto.setPwd(pwd);
		
		ArrayList<MemberDto> memberList = contactService.memberSearchAll();
		request.setAttribute("memberList", memberList);
		request.setAttribute("memberDto", memberDto);
		RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
		disp.forward(request, response);
	}

}
