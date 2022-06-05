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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		contactService.join(memberDto);
		contactService.memberDelete();
		response.sendRedirect("login.jsp");
	}//doGet 종료

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDto memberDto = new MemberDto();
		String memid = request.getParameter("memid");
		String pwd	 = request.getParameter("pwd");
		memberDto.setMemid(memid);
		memberDto.setPwd(pwd);
		
		ContactService contactService = new ContactService();
		boolean result = true;
		result = contactService.login(memberDto);
		if(result) {
			HttpSession session = request.getSession(true);
			session.setAttribute("memid", memid);
			
			ArrayList<MemberDto> memberList = contactService.memberSearchAll();
			request.setAttribute("memberList", memberList);
			RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
			disp.forward(request, response);
		}else {
			response.sendRedirect("LoginServlet");
		}
	}//doPost 종료

}//class 종료
