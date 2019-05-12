package com.seoul.tureservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.TureBoard;
import com.seoul.service.TureBoardService;

@WebServlet(value = "/turedelete.action")
public class TureBoardDeleteServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}//회원정보가 null이면 login으로 이동
		
		
		//1.요청 데이터 읽기 브라우저에서 전송한 데이터 읽기(boardno)
		String sBoardNo = req.getParameter("boardno");
		//바로 detail.action으로 갈 경우 list.action으로 이동
		int boardNo = -1;
		try{
			boardNo = Integer.parseInt(sBoardNo);
		} catch(Exception ex){
			resp.sendRedirect("/demoweb/board/list.action");
			return;
		}
				
		
		//2.boardno로 데이터 삭제(BoardService 사용)
		//조회실패(결과가 null) list.action으로
		TureBoardService boardService = new TureBoardService();
		boardService.deleteBoard(boardNo);
		req.setAttribute("delete", true);
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/tureboard/turedetail.jsp");
			dispatcher.forward(req, resp);
		
		
		
	}
	
}
