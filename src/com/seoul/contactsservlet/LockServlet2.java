package com.seoul.contactsservlet;

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

@WebServlet(value = "/contacts/lock2.action")
public class LockServlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sBoardNo = req.getParameter("boardno");
		String checkPasswd = req.getParameter("password1");
		ContactsBoardService boardService = new ContactsBoardService();
		int boardNo = -1;
		String page = req.getParameter("pageno");
		int pageNo = Integer.parseInt(page);
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("lock.action?boardno="+boardNo+"&pageno="+pageNo);
			return;
		}
		String password = boardService.checkPassword(boardNo);
		//2. boardno로 데이터 조회 (BoardService 사용)
		//   조회 실패하면 (결과가 null) list.action으로 이동
		if (checkPasswd.equalsIgnoreCase(password)) {
			ContactsBoard board = boardService.findBoardByBoardNo(boardNo);
			
			//페이지 번호 읽기
			int currentPage = 1;//요청된 페이지 번호가 없을 때 사용할 번호
			try {
				currentPage = Integer.parseInt(page);//요청된 페이지 번호
			} catch (Exception ex) {
			}		
			
			//4. 조회 결과를 request 객체에 저장 (JSP에서 사용하도록)
			req.setAttribute("board", board);
			req.setAttribute("pageno", currentPage);
			
			//5. detail.jsp로 이동
			resp.sendRedirect("contactsdetail.action?boardno="+boardNo+"&pageno="+pageNo);
;
			} else {
			
			resp.sendRedirect("lock.action?boardno="+boardNo+"&pageno="+pageNo);
				
			}
		}
		
	
}
