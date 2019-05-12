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


@WebServlet(value ="/seoulmate/detail.action")
public class GuideBoardDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//아래 인증코드는 필터로 구현합니다.
		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}
		
		
		
		//1.요청 데이터 읽기(boardno)
		// -boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("gub_boardno");
		int gub_BoardNo = -1;
		try {
			gub_BoardNo = Integer.parseInt(sBoardNo);
		}	catch (Exception ex) {
			resp.sendRedirect("/seoul/list.action");
			ex.printStackTrace();
			return;
		}
		
		
		
		
		
		//2.boardno로 데이터 조회(boardService 사용)
		//조회 실패하면(결과가 null이면) list.action으로 이동
		GuideBoardService guideBoardService = new GuideBoardService();
		Guide guide = guideBoardService.findBoardByBoardNo(gub_BoardNo);
		if (guide == null) {
			resp.sendRedirect("/seoul/list.action");
			return;
		}
		
		//조회수 증가 처리
		guide.setGub_ReadCount(guide.getGub_ReadCount() + 1); //읽은 후에 증가 시켜줘야 한다
		guideBoardService.increaseReadCount(gub_BoardNo);
		
		
		
		String page = req.getParameter("pageno");
		//현재 페이지를 기본적으로 1페이지를 잡고 정상적으로 수행되면 그 요청된 페이지 번호를잡고 실패하면 1페이지로 유지
		int currentPage = 1; //요청된 페이지가 없을때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); //요청된 페이지 번호
		} catch (Exception ex) {	
		}
		
		System.out.println("3");
		//3.조회 결과를 request 객체에 저장(jsp에서 사용하도록)
		req.setAttribute("guide", guide);
		req.setAttribute("pageno", currentPage);
		
		
		
		//4.detail.jsp로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/seoulmate/guidedetail.jsp");
		dispatcher.forward(req, resp);

		
	}
	
}
