package com.seoul.contactsservlet;

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

import com.seoul.dto.ContactsBoard;
import com.seoul.service.ContactsBoardService;
import com.seoul.ui.ThePager;
import com.seoul.ui.ThePager2;

@WebServlet(value = "/contacts/contactssearch.action")
public class ContactsSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String search1 = req.getParameter("search1");
		String search2 = req.getParameter("search2");
		int pageSize = 5;
		int pagerSize = 3;
		int boardCount = 0;
		String linkUrl = "contactssearch.action";
		
		String page = req.getParameter("pageno");
		int currentPage = 1;//��û�� ������ ��ȣ�� ���� �� ����� ��ȣ
		try {
			currentPage = Integer.parseInt(page);//��û�� ������ ��ȣ
		} catch (Exception ex) {
		}
		
		int first = (currentPage - 1) * pageSize + 1;
		int last = first + pageSize;
		
		
		//������ ó�� (�Խ��� �� ��� ��ȸ)
		ContactsBoardService boardService = new ContactsBoardService();
		//List<Board> boards = boardService.findBoardList();
		List<ContactsBoard> boards = boardService.findBoardList5(search1, search2, first, last);//추가**
		
		boardCount = boardService.getBoardCount5(search1, search2);
		ThePager2 pager2 = new ThePager2(boardCount, currentPage,
				pageSize, pagerSize, linkUrl, search1, search2);
		
		//JSP���� ����� �� �ֵ��� request��ü�� ��ȸ�� ������ ����
		req.setAttribute("boards", boards);
		req.setAttribute("pager2", pager2);
		req.setAttribute("pageno", currentPage);
		
		//list.jsp�� �̵�
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/contacts/contactssearch.jsp");
		dispatcher.forward(req, resp);
		
	}
}
