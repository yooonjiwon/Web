
package com.seoul.guideservlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
import com.seoul.ui.ThePager;

@WebServlet(value ="/seoulmate/list.action")
public class GuideListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*페이징 기능 구현으로 추가된 부분*/
		int pageSize = 8;
		int pagerSize = 10;
		int boardCount = 0;
		String linkUrl = "list.action"; //페이징 번호를 클릭하면 바뀌는 링크페이지를 지정
		
		
		String page = req.getParameter("pageno");
		//현재 페이지를 기본적으로 1페이지를 잡고 정상적으로 수행되면 그 요청된 페이지 번호를잡고 실패하면 1페이지로 유지
		int currentPage = 1; //요청된 페이지가 없을때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); //요청된 페이지 번호
		} catch (Exception ex) {	
		}
		
		
		int first = (currentPage - 1) * pageSize + 1;
		int last = first + pageSize;
		
		
		
		
		
		
		//데이터 처리 ( 게시판 글 목록 조회)
		GuideBoardService guideService = new GuideBoardService();
		
		
		/*페이징 기능 구현으로 수정된 부분*/
		List<Guide> guides = guideService.findBoardList(first, last);
		
		
		/*페이징 버튼 기능 구현으로 추가된 부분*/
		boardCount = guideService.getGuideBoardCount();
		ThePager pager = new ThePager(boardCount, currentPage, pageSize, pagerSize, linkUrl);
		
		
		
		//jsp에서 사용할 수 있도록 request객체에 조회된 데이터 저장
		req.setAttribute("guides", guides);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/seoulmate/seoulmate.jsp");
		dispatcher.forward(req, resp);

		
	}
	
}
