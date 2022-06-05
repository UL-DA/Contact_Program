package com.kbigdata.contactApp.controller;

import java.io.IOException;
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
 * Servlet implementation class ContactDeleteServlet
 */
@WebServlet("/ContactDeleteServlet")
public class ContactDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactDeleteServlet() {
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
		contactService.deleteContact(contactDto);
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("contactDto", contactDto);
		RequestDispatcher disp = request.getRequestDispatcher("ContactSearchAllServlet");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
