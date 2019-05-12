package com.seoul.tureservlet;

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

import com.seoul.dto.TureBoard;
import com.seoul.dto.TureBoardAttach;
import com.seoul.service.TureBoardService;
import com.seoul.ui.ThePager;

@WebServlet(value = "/turelist.action")
public class TureBoardListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageSize = 12;
		int pagerSize = 3;
		int boardCount = 0;
		String linkUrl = "turelist.action";
		String page =  req.getParameter("pageno");//브라우저 주소창에 pageno를 주었을때
		int currentPage = 1;//요청된 페이지 번호가 없을때
		try{
			currentPage = Integer.parseInt(page);//요청된 페이지 번호
		} catch(Exception e){
			
		}
		
		int first = (currentPage - 1)*pageSize+1;
		int last = first + pageSize;
		//데이터 처리 (게시판 글 목록 조회)
		TureBoardService boardService = new TureBoardService();
		//List<Board> boards = boardService.findBoardList();
		List<TureBoard> boards = boardService.findBoardList(first, last);
		
		boardCount = boardService.getBoardCount();
		
		ThePager pager = new ThePager(boardCount, currentPage, pageSize, pagerSize, linkUrl);
		//JSP에서 사용할 수 있도록 request객체에 조회된 데이터 저장
		req.setAttribute("boards", boards);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);
		//list.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/tureboard/turelist.jsp");
		dispatcher.forward(req, resp);
	}
	
}


