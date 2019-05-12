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

import com.seoul.dto.ContactsBoard;
import com.seoul.service.ContactsBoardService;

@WebServlet(value = "/contacts/lock3.action")
public class InformationLockServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//아래 인증코드는 필터로 구현합니다.
//		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}
		req.setCharacterEncoding("utf-8");
		//1. 요청 데이터(브라우저에서 전송한 데이터) 읽기 (boardno)
		//   - boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("boardno");		
		int boardNo = -1;
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("lock3.action");
			return;
		}
		
		//2. boardno로 데이터 조회 (BoardService 사용)
		//   조회 실패하면 (결과가 null) list.action으로 이동
		ContactsBoardService boardService = new ContactsBoardService();
		ContactsBoard board = boardService.findBoardByBoardNo(boardNo);
		if (board == null) {
			resp.sendRedirect("lock.action");
			return;
		}
		
		//페이지 번호 읽기
		String page = req.getParameter("pageno");
		int currentPage = 1;//요청된 페이지 번호가 없을 때 사용할 번호
		try {
			currentPage = Integer.parseInt(page);//요청된 페이지 번호
		} catch (Exception ex) {
		}		
		
		//4. 조회 결과를 request 객체에 저장 (JSP에서 사용하도록)
		req.setAttribute("board", board);
		req.setAttribute("pageno", currentPage);
		
		//5. detail.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/information/informationlock.jsp");
		dispatcher.forward(req, resp);
		
	}
}
