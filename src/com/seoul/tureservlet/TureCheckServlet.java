package com.seoul.tureservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.dto.TureBoardComment;
import com.seoul.dto.TureMember;
import com.seoul.service.TureBoardService;

@WebServlet(value = "/board/check.action")
public class TureCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//브라우저에서 전송된 요청 데이터 읽기
		
		req.setCharacterEncoding("utf-8");
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String sPageNo = req.getParameter("pageno");
		int pageNo = Integer.parseInt(sPageNo);
		String content = req.getParameter("content");
		
		//데이터베이스에 데이터 저장
		
		TureBoardComment comment = new TureBoardComment();
		comment.setBoardNo(boardNo);
		comment.setContent(content);
		TureMember member = (TureMember)req.getSession().getAttribute("loginuser");//session에서 loginuser을 가져와서 Member class의 변수 member에 저장
		comment.setWriter(member.getMemberId());//BoardComment class의 comment 에 boardNo, content, writer을 저장
		
		TureBoardService service = new TureBoardService();
		service.writeComment(comment);
		
		
		//이동
		resp.sendRedirect(String.format("detail.action?boardno=%s&pageno=%s", sBoardNo, sPageNo));
	}
	
}
