package com.seoul.contactsservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.dto.ContactsBoard;
import com.seoul.service.ContactsBoardService;
import com.seoul.ui.ThePager;

@WebServlet(value = "/contacts/eventlist.action")
public class EventListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int pageSize = 5;
		int pagerSize = 3;
		int boardCount = 0;
		String linkUrl = "eventlist.action";
		
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
		List<ContactsBoard> boards = boardService.findBoardList2(first, last);//추가**
		
		boardCount = boardService.getBoardCount2();
		ThePager pager = new ThePager(boardCount, currentPage,
				pageSize, pagerSize, linkUrl);
		
		//JSP���� ����� �� �ֵ��� request��ü�� ��ȸ�� ������ ����
		req.setAttribute("boards", boards);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);
		
		//list.jsp�� �̵�
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/contacts/eventlist.jsp");
		dispatcher.forward(req, resp);
	}

}
