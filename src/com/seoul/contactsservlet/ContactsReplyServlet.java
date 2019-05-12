package com.seoul.contactsservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.common.Util;
import com.seoul.dto.ContactsBoard;
import com.seoul.dto.Member;
import com.seoul.service.ContactsBoardService;
import com.seoul.service.MemberService;

@WebServlet(value = "/contacts/contactsreply.action")
public class ContactsReplyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String sBoardNo = req.getParameter("boardno");		
		int boardNo = -1;
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("contactslist.action");
			return;
		}
		
		req.setAttribute("boardno", boardNo);
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/contacts/contactsreply.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String title = req.getParameter("title");
		String writer = req.getParameter("writer"); //방법 2		
		String content = req.getParameter("content");
		String password = req.getParameter("password");
		
		ContactsBoard board = new ContactsBoard();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setPassword(password);
		
		ContactsBoardService boardService = new ContactsBoardService();
		boardService.replyBoard1(board);

		resp.sendRedirect("contactslist.action");
	}
	
}