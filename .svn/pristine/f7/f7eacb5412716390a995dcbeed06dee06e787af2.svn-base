package com.seoul.memberservlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.common.Util;
import com.seoul.dto.Member;
import com.seoul.service.MemberService;

@WebServlet(value="/account/signup.action")
public class SignupServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/account/signup.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String name = req.getParameter("name");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		String birthday = req.getParameter("birthday");
		String country_code = req.getParameter("country_code");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String nation = req.getParameter("nation");
		String interest = req.getParameter("interest");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setName(name);
		passwd = Util.getHashedString(passwd, "SHA-256");
		member.setPasswd(passwd);
		member.setEmail(email);
		member.setBirthday(birthday);
		member.setCountry_code(country_code);
		member.setPhone(phone);
		member.setGender(gender);
		member.setNation(nation);
		member.setInterest(interest);
		member.setActive(true);
		member.setUserType("user");
		member.setRegDate(new Date());
		
		MemberService memberService = new MemberService();
		memberService.registerMember(member);
		
		resp.sendRedirect("/seoul/index.jsp");
	}
}
