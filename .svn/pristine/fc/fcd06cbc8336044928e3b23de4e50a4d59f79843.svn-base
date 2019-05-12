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

import com.seoul.dto.Member;
import com.seoul.dto.TureBoard;
import com.seoul.dto.TureBoardAttach;
import com.seoul.dto.TureMember;
import com.seoul.service.TureBoardService;
import com.seoul.ui.ThePager;

@WebServlet(value = "/turechecklist.action")
public class TureMyCheckListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) {
			resp.sendRedirect("/seoul/account/login.action");
			return;
		}		
		

		Member member = (Member)req.getSession().getAttribute("loginuser");
		
		//데이터 처리 (게시판 글 목록 조회)
		TureBoardService boardService = new TureBoardService();
		//List<Board> boards = boardService.findBoardList();
		
		List<TureBoard> boards = boardService.findMyCheckBoardList(member.getMemberId());
		//JSP에서 사용할 수 있도록 request객체에 조회된 데이터 저장
		
		
		//JSP에서 사용할 수 있도록 request객체에 조회된 데이터 저장
		req.setAttribute("boards", boards);
		
		
		//list.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/tureboard/turemychecklist.jsp");
		dispatcher.forward(req, resp);
	}
	
}


