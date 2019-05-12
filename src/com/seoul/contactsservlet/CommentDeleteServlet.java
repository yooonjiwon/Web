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

@WebServlet(value = "/contacts/commentdelete.action")
public class CommentDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//요청 데이터(브라우저에서 전송한 데이터) 읽기
		String sCommentNo = req.getParameter("commentno");
		int commentNo = Integer.parseInt(sCommentNo);
		String sBoardNo = req.getParameter("boardno");
		String sPageNo = req.getParameter("pageno");		
		//commentno로 데이터 삭제 (BoardService 사용)
		ContactsBoardService boardService = new ContactsBoardService();
		boardService.deleteComment(commentNo);		
		//3. detail.action으로 이동
		resp.sendRedirect(String.format(
			"contactsdetail.action?boardno=%s&pageno=%s", 
			sBoardNo, sPageNo));
	}
	
}
