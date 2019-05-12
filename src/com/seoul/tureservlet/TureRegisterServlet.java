package com.seoul.tureservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.common.Util;
import com.seoul.dto.TureMember;
import com.seoul.service.TureMemberService;

@WebServlet(value = "/account/register.action")
public class TureRegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		//회원가입화면 응답
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("	<meta charset='utf-8' />");
//		out.println("	<title>사용자등록</title>");
//		out.println("	<link rel='Stylesheet' href='/demoweb/styles/default.css' />");
//		out.println("	<link rel='Stylesheet' href='/demoweb/styles/input.css' />");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<div id='pageContainer'>");
//		out.println("<div id='header'>");    	
//		out.println("            <div class='title'>");
//		out.println("                <a href=''>DEMO WEBSITE</a>");
//		out.println("            </div>");
//		out.println("            <div class='links'>");		            	
//		out.println("            	<a href='/demoweb/account/loginform.action'>로그인</a>");
//		out.println("                <a href='/demoweb/account/registerform.action'>회원가입</a>");				                
//		out.println("            </div>");
//		out.println("        </div>");        
//		out.println("        <div id='menu'>");
//		out.println("            <div>");
//		out.println("                <ul>");
//		out.println("                    <li><a href=''>사용자관리</a></li>");
//		out.println("					<li><a href=''>메일보내기</a></li>");
//		out.println("					<li><a href=''>자료실</a></li>");
//		out.println("					<li><a href=''>게시판</a></li>");
//		out.println("                </ul>");
//		out.println("            </div>");
//		out.println("		</div>");		
//		out.println("		<div id='inputcontent'>");
//		out.println("			<br /><br />");
//		out.println("		    <div id='inputmain'>");
//		out.println("		        <div class='inputsubtitle'>회원기본정보</div>");
//		out.println("		        <form action='register.action' method='post'>");
//		out.println("		        <table>");
//		out.println("		            <tr>");
//		out.println("		                <th>아이디(ID)</th>");
//		out.println("		                <td>");
//		out.println("		                    <input type='text' id='memberId' name='memberId' style='width:280px' />");
//		out.println("		                </td>");
//		out.println("		            </tr>");
//		out.println("		            <tr>");
//		out.println("		                <th>비밀번호</th>");
//		out.println("		                <td>");
//		out.println("		                	<input type='password' id='passwd' name='passwd' style='width:280px' />");
//		out.println("		                </td>");
//		out.println("	            </tr>");
//		out.println("		            <tr>");
//		out.println("		                <th>비밀번호 확인</th>");
//		out.println("		                <td>");
//		out.println("		                    <input type='password' id='confirm' name='confirm' style='width:280px' />");
//		out.println("		                </td>");
//		out.println("		            </tr>");
//		out.println("		            <tr>");
//		out.println("		                <th>이메일</th>");
//		out.println("		                <td>");
//		out.println("		                	<input type='text' id='email' name='email' style='width:280px' />");
//		out.println("		                </td>");
//		out.println("		            </tr>");
//		out.println("		        </table>");
//		out.println("		        <div class='buttons'>");
//		out.println("		        	<input type='submit' value='등록' style='height:25px' />");
//		out.println("		        	<input type='button' value='취소' style='height:25px' onclick=\"location.href='/demoweb/'\" />");	
//		out.println("		        </div>");
//		out.println("		        </form>");
//		out.println("		    </div>");
//		out.println("		</div>");
//		out.println("	</div>");
//		out.println("</body>");
//		out.println("</html>");	
		
		///////////////////////////////////////////////
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
						  //브라우저에서 전송된 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		
//		resp.setContentType("text/plain;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.println(memberId + " / " + passwd + " / " +
//					confirm + " / " + email);
		
		//사용자의 요청 데이터를 Member 객체에 저장
		TureMember member = new TureMember();
		member.setMemberId(memberId);
		passwd = Util.getHashedString(passwd, "SHA-256");
		member.setPasswd(passwd);
		member.setEmail(email);
		member.setUserType("user");
		member.setActive(true);
		member.setRegDate(new Date());
		
		//사용자 등록 처리
		TureMemberService memberService = new TureMemberService();
		memberService.registerMember(member);
		
		//home으로 이동
		//RequestDispatcher dispatcher = 
		//	req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		//dispatcher.forward(req, resp);
		
		//resp.sendRedirect("/demoweb/WEB-INF/views/home.jsp");
		
		resp.sendRedirect("/demoweb/home.action");
	}
	
}






