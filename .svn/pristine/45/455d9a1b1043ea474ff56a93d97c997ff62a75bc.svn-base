package com.seoul.guideservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.Guide;
import com.seoul.service.GuideBoardService;

@WebServlet(value ="/seoulmate/delete.action")
public class GuideBoardDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//아래 인증코드는 필터로 구현합니다.
		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}
		
		
		
		//1.요청 데이터(브라우저에서 전송한 데이터) 읽기(boardno)
		// -boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("gub_boardno");
		int gub_BoardNo = -1;
		try {
			gub_BoardNo = Integer.parseInt(sBoardNo);
		}	catch (Exception ex) {
			resp.sendRedirect("/seoul/list.action");
			return;
		}
		
		//2.boardno로 데이터 삭제(boardService 사용)
		GuideBoardService guideBoardService = new GuideBoardService();
		guideBoardService.deleteBoard(gub_BoardNo);
		
		
		//3.list.action로 이동
		//resp.sendRedirect("/demoweb/board/list.action");
		resp.sendRedirect("/seoul/seoulmate/list.action"); //상대 경로로 처리해도 같은 결과
		
	}
	
}
