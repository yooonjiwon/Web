package com.seoul.contactsservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.dto.ContactsComment;
import com.seoul.dto.Member;
import com.seoul.service.ContactsBoardService;

@WebServlet(value = "/contacts/commentwrite.action")
public class CommentWriteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		//브라우저에서 전송된 요청 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String sPageNo = req.getParameter("pageno");
		int pageNo = Integer.parseInt(sPageNo);
		String content = req.getParameter("content");		
		//데이터베이스에 데이터 저장	
		ContactsComment comment = new ContactsComment();
		comment.setBoardNo(boardNo);
		comment.setContent(content);
		Member member = (Member)req.getSession().getAttribute("loginuser");
		comment.setWriter(member.getMemberId());
		
		ContactsBoardService service = new ContactsBoardService();
		service.writeComment(comment);
		//이동
		resp.sendRedirect(
			String.format("contactsdetail.action?boardno=%s&pageno=%s",
					sBoardNo, sPageNo));		
	}
	
}