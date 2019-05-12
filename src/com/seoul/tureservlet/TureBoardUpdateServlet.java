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

@WebServlet(value = "/tureupdate.action")
public class TureBoardUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}	
		
		//1.요청 데이터 읽기 브라우저에서 전송한 데이터 읽기(boardno)
		String sBoardNo = req.getParameter("boardno");
		//바로 detail.action으로 갈 경우
		int boardNo = -1;
		try{
			boardNo = Integer.parseInt(sBoardNo);
		} catch(Exception ex){
			resp.sendRedirect("/seoul/turelist.action");
			return;
		}
				
		
		//2.boardno로 데이터 조회(BoardService 사용)
		//조회실패(결과가 null) list.action으로
		TureBoardService boardService = new TureBoardService();
		TureBoard board = boardService.findBoardByBoardNo(boardNo);
		if (board == null){
			resp.sendRedirect("/seoul/turelist.action");
			return;
		}
		String page =  req.getParameter("pageno");//브라우저 주소창에 pageno를 주었을때
		int currentPage = 1;//요청된 페이지 번호가 없을때
		try{
			currentPage = Integer.parseInt(page);//요청된 페이지 번호
		} catch(Exception e){
			
		}
		//단일값으로 나오기 때문에 List 사용안함
		//3. 조회 결과를 request 객체에 저장(JSP에서 사용하도록)
		req.setAttribute("board", board);
		req.setAttribute("pageno", currentPage);
		
		//detail.jsp으로 이동
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/tureboard/tureedit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		  //브라우저에서 전송된 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		String title = req.getParameter("title");
		int boardno = Integer.parseInt(sBoardNo);
			
		
		String content = req.getParameter("content");
		//사용자의 요청 데이터를 Board 객체에 저장
		TureBoard board = new TureBoard();
		board.setTitle(title);
		board.setBoardNo(boardno);
		board.setContent(content);
		//사용자 등록 처리
		TureBoardService boardService = new TureBoardService();
		boardService.UpdateBoard(board);

		resp.sendRedirect("/seoul/turedetail.action?boardno="+ boardno);
	}
	
}
