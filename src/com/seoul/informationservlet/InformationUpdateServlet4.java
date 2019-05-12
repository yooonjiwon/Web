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

@WebServlet(value = "/information/update34.action")
public class InformationUpdateServlet4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 요청 데이터 읽기 (boardno)
		//	- boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("boardno");
		int boardNo = -1;
		try {
			boardNo = 	Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("/seoul/information/list34.action");
			return;
		}

		//2. boardno로 데이터 조회 (BoardService 사용)
		//	 조회 실패하면 (결과가 null) list.action으로 이동
		InformationBoardService boardService = new InformationBoardService();
		Information board = boardService.findBoardByBoardNo4(boardNo);
			if (board == null) {
				resp.sendRedirect("/seoul/information/list34.action");
				return;
			}

		//페이지 번호 읽기
		String page = req.getParameter("pageno");
		int currentPage = 1; //요청된 페이지 번호가 없을 때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); //요청된 페이지 번호
		} catch (Exception ex) {
		}

		//3. 조회 결과를 request 객체에 저장 (JSP에서 사용하도록)
		req.setAttribute("board", board);
		req.setAttribute("pageno", currentPage);

		//4. detail.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/information/informationedit4.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		//브라우저에서 전송된 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String in_area = req.getParameter("area");		
		String in_title = req.getParameter("title");
		String m_memberid = req.getParameter("memberid");
		String in_address = req.getParameter("address");
		String in_telephone = req.getParameter("telephone");
		String in_content = req.getParameter("content");

		//사용자의 요청 데이터를 Board 객체에 저장
		Information board = new Information();
		board.setIn_No(boardNo);
		board.setIn_Area(in_area);
		board.setIn_Title(in_title);
		board.setM_MemberId(m_memberid);
		board.setIn_Address(in_address);
		board.setIn_Telephone(in_telephone);
		board.setIn_Content(in_content);

		//사용자 수정 처리
		InformationBoardService boardService = new InformationBoardService();
		boardService.updateBoard4(board);
		resp.sendRedirect("/seoul/information/detail34.action?boardno=" + boardNo);
	}	
}
