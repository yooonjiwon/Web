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
import javax.servlet.http.HttpSession;

import com.seoul.common.Util;
import com.seoul.dto.TureBoard;
import com.seoul.dto.TureMember;
import com.seoul.service.TureBoardService;
import com.seoul.service.TureMemberService;

@WebServlet(value = "/board/write2.action")
public class TureBoardWriteServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 하지 않은 경우 로그인 화면으로 이동
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) {
			resp.sendRedirect("/demoweb/account/login.action");
			return;
		}		
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/board/write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		  //브라우저에서 전송된 데이터 읽기
		String title = req.getParameter("title");
		
		//String writer = "iamuserone";				//for test
		//Member member = 
		//		(Member)req.getSession().getAttribute("loginuser");	//방법 1
		//String writer = member.getMemberId();						//방법 1
		String writer = req.getParameter("writer"); //방법 2
		
		String content = req.getParameter("content");
		//사용자의 요청 데이터를 Board 객체에 저장
		TureBoard board = new TureBoard();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		//사용자 등록 처리
		TureBoardService boardService = new TureBoardService();
		boardService.writeBoard(board);

		resp.sendRedirect("/demoweb/board/list.action");
	}
	
}
