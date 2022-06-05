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

import com.kbigdata.contactApp.dto.MemberDto;
import com.kbigdata.contactApp.service.ContactService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
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
		request.setAttribute("memberDto", memberDto);
		RequestDispatcher disp = request.getRequestDispatcher("memberUpdate.jsp");
		disp.forward(request, response);
	}//doGet 종료

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memid   = request.getParameter("memid");
		String pwd 	   = request.getParameter("pwd");
		String memname = request.getParameter("memname");
		String memtel  = request.getParameter("memtel");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemid(memid);
		memberDto.setPwd(pwd);
		memberDto.setMemname(memname);
		memberDto.setMemtel(memtel);
		
		ContactService contactService = new ContactService();
		contactService.memberUpdate(memberDto);
		
		HttpSession session = request.getSession();
		session.getAttribute("memid");
		memid = (String)session.getAttribute("memid");
		
		memberDto = contactService.selectById(memid);
		ArrayList<MemberDto> memberList = contactService.memberSearchAll();
		request.setAttribute("memberList", memberList);
		request.setAttribute("memberDto", memberDto);
		RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
		disp.forward(request, response);
	}//doPost 종료

}//class 종료
