package com.seoul.informationservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.Information;
import com.seoul.service.InformationBoardService;

@WebServlet(value = "/information/delete33.action")
public class InformationDeleteServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//아래 인증코드는 필터로 구현합니다.(AuthFilter.java에서 구현)
//		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}
		
		//1. 요청 데이터 읽기 (boardno)
		//	- boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("boardno");
		int boardNo = -1;
		try {
			boardNo = 	Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("/seoul/information/list33.action");
			return;
		}

		//2. boardno로 데이터 삭제 (BoardService 사용)
		InformationBoardService boardService = new InformationBoardService();
		boardService.deleteBoardNo3(boardNo);
		
		//3. list.action으로 이동		 
		resp.sendRedirect("list33.action");		
	}
}
