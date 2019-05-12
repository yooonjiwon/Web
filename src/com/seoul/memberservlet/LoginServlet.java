package com.seoul.memberservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.common.Util;
import com.seoul.dto.Member;
import com.seoul.service.MemberService;

import com.seoul.dto.TureMember;
import com.seoul.service.TureMemberService;
import com.seoul.dto.TureCommenteCount;

@WebServlet(value = "/account/login.action")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//home으로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		MemberService memberService = new MemberService();
		Member member = memberService.authenticate(memberId, passwd);
		
		TureMemberService TureMemberService = new TureMemberService();
		TureCommenteCount count = TureMemberService.readcount(memberId);
		
		if (member == null) {
			resp.sendRedirect("/seoul/account/login.action");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", member);
			session.setAttribute("commentcount", count);
			resp.sendRedirect("/seoul/index.action");
		}
	}
}
