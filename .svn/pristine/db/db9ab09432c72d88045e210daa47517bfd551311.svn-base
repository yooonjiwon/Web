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

@WebServlet(value = "/account/idcheck.action")
public class IdCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");

		MemberService memberService = new MemberService();
		int count = memberService.checkDuplicate(memberId);

		req.setAttribute("rst", count);
		req.setAttribute("memberId", memberId);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/idcheck.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

