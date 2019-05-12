package com.seoul.informationservlet;

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

import com.seoul.dto.Information;
import com.seoul.service.InformationBoardService;
import com.seoul.ui.ThePager;

@WebServlet(value = "/information/list36.action")
public class InformationListServlet6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageSize = 5;
		int pagerSize = 3;
		int boardCount = 0;
		String linkUrl = "list36.action";
//////////////////////   페이저 기능  //////////////////////
		String page = req.getParameter("pageno");
		int currentPage = 1; //요청된 페이지 번호가 없을 때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); //요청된 페이지 번호
		} catch (Exception ex) {
		}

		int first = (currentPage - 1) * pageSize + 1;
		int last = first + pageSize;
///////////////////////// 서비스로 넘겨 /////////////////////
		
		//데이터 처리 (게시판 글 목록 조회)
		InformationBoardService boardService = new InformationBoardService();
		List<Information> boards = boardService.findBoardList6(); //List<Board> : 리스트 목록이 한건이 아니고 여러건이기때문에 씀(복수처리)
		
		//페이저 기능도 서비스로 넘겨
		boardCount = boardService.getBoardCount6();
		ThePager pager = new ThePager(boardCount, currentPage, pageSize, pagerSize, linkUrl);

//////////////////////////////////////////////////////////////		
		
		//JSP에서 사용할 수 있도록 request객체에 조회된 데이터 저장
		req.setAttribute("boards", boards);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);

		//list.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/information/informationlist6.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}

