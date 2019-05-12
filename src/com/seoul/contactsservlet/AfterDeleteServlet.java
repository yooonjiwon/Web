package com.seoul.contactsservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.ContactsBoard;
import com.seoul.service.ContactsBoardService;

@WebServlet(value = "/contacts/afterdelete.action")
public class AfterDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//아래 인증코드는 필터로 구현합니다.
//		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}
		
		//1. 요청 데이터(브라우저에서 전송한 데이터) 읽기 (boardno)
		//   - boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("boardno");		
		int boardNo = -1;
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("afterlist.action");
			return;
		}
		
		//2. boardno로 데이터 삭제 (BoardService 사용)
		ContactsBoardService boardService = new ContactsBoardService();
		boardService.deleteBoard(boardNo);
		
		//3. list.action으로 이동
		//resp.sendRedirect("/demoweb/board/list.action");
		resp.sendRedirect("afterlist.action");
	}
	
}
