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

import com.seoul.dto.Member;
import com.seoul.dto.TureBoard;
import com.seoul.service.TureBoardService;
import com.sun.glass.ui.Window;

@WebServlet(value = "/tureguideprofile.action")
public class TureGuidProfileServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) {
			resp.sendRedirect("/seoul/account/login.action");
			return;
		}	
		
		//1.요청 데이터 읽기 브라우저에서 전송한 데이터 읽기(boardno)
		String guideId = req.getParameter("guideid");
		String listId = req.getParameter("listid");
		System.out.println(guideId);
		//바로 detail.action으로 갈 경우
//		int boardNo = -1;
//		try{
//			boardNo = Integer.parseInt(sBoardNo);
//		} catch(Exception ex){
//			resp.sendRedirect("/seoul/turelist.action");
//			return;
//		}
				
		
		//2.boardno로 데이터 조회(BoardService 사용)
		//조회실패(결과가 null) list.action으로
		TureBoardService boardService = new TureBoardService();
		Member guideProfile = boardService.findGuideProfileByMemberId(guideId);
		
		if (guideProfile == null){
			resp.sendRedirect("/seoul/turelist.action");
			return;
		}
		//조회수 증가처리
//		board.setReadCount(board.getReadCount()+1);//글 읽기전에 카운트를 1 올려줌
//		boardService.increaseReadCount(boardNo);
		
//		String page =  req.getParameter("pageno");//브라우저 주소창에 pageno를 주었을때
//		int currentPage = 1;//요청된 페이지 번호가 없을때
//		try{
//			currentPage = Integer.parseInt(page);//요청된 페이지 번호
//		} catch(Exception e){
//			
//		}
		System.out.println(guideProfile.getMemberId());
		//단일값으로 나오기 때문에 List 사용안함
		//3. 조회 결과를 request 객체에 저장(JSP에서 사용하도록)
//		req.setAttribute("board", board);
		req.setAttribute("guideId", guideProfile);
		req.setAttribute("listid", listId);
//		
		//detail.jsp으로 이동
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/tureboard/tureguideprofile.jsp");
		dispatcher.forward(req, resp);
	}
	
}
