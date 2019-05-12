package com.seoul.informationservlet;

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
import com.seoul.dto.Information;
import com.seoul.service.InformationBoardService;

@WebServlet(value = "/information/write34.action")
public class InformationWriteServlet4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//아래 인증코드는 필터로 구현합니다.(AuthFilter.java에서 구현)
//		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}

		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/information/informationwrite4.jsp");
		dispatcher.forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
/*		String sBoardNo = req.getParameter("boardno");
		if (sBoardNo == null) {
			sBoardNo = "0";
		}
		int in_no = Integer.parseInt(sBoardNo);*/

		//브라우저에서 전송된 데이터 읽기
		String in_area = req.getParameter("area");
		String in_title = req.getParameter("title");
		String m_memberid = req.getParameter("memberid");
		String in_address = req.getParameter("address");
		String in_telephone = req.getParameter("telephone");
		String in_content = req.getParameter("content");

		//사용자의 요청 데이터를 Board 객체에 저장
		Information information = new Information();
		/*information.setIn_No(in_no);*/
		information.setIn_Area(in_area);
		information.setIn_Title(in_title);
		information.setM_MemberId(m_memberid);
		information.setIn_Address(in_address);
		information.setIn_Telephone(in_telephone);
		information.setIn_Content(in_content);
		//사용자 등록 처리
		InformationBoardService boardService = new InformationBoardService();
		boardService.writeBoard4(information);
		
		resp.sendRedirect("/seoul/information/list34.action");
	}
}

