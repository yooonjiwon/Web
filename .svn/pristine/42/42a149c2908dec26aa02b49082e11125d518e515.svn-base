package com.seoul.memberservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.Member;
import com.seoul.service.MemberService;

/******************프로필 수정 서블릿*********************/

@WebServlet(value = "/account/memberupdate.action")
public class MemberUpdateServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 여부 확인 -> 로그인 하지 않은 경우 로그인 화면으로 이동
		HttpSession session = req.getSession();
		if(session.getAttribute("loginuser")==null) {
			System.out.println("alert('세션이 만료되었습니다.')");
			resp.sendRedirect("/seoul/index.action");
			return; 
		}
		
		// 요청 데이터 읽기 (memeberId)
		String memberId = req.getParameter("memberId");
		
		// memberId로 데이터 조회
		
		MemberService memberService = new MemberService();
		Member member = memberService.findMemberByMemberId(memberId);
		/*if (member == null) {
			resp.sendRedirect("/index.action");
			return;
		}*/
		
		//결과 member 객체에 저장
		req.setAttribute("member", member);
		
		// mypage.jsp로 이동
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/account/mypage.jsp");
			dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// 브라우저에서 전송된 데이터 읽기
		String smemberId = req.getParameter("memberId");
		String name = req.getParameter("name");
		String email = req.getParameter("email"); 
		String birthday = req.getParameter("birthday");
		String country_code = req.getParameter("country_code");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String nation = req.getParameter("nation");
		String interest = req.getParameter("interest");

		// 사용자의 데이터를 Member 객체에 저장
		Member member = new Member();
		member.setMemberId(smemberId);
		member.setName(name);
		member.setEmail(email);
		member.setBirthday(birthday);
		member.setCountry_code(country_code);
		member.setPhone(phone);
		member.setGender(gender);
		member.setNation(nation);
		member.setInterest(interest);
		
		// 수정 처리
		MemberService memberService = new MemberService();
		memberService.updateMember(member);
		
		//메인으로 이동
		resp.sendRedirect("/seoul/index.action");
	}
	
}