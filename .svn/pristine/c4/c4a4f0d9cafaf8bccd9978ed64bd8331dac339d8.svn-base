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

import com.seoul.dto.TureBoard;
import com.seoul.dto.TureBoardComment;
import com.seoul.service.TureBoardService;

@WebServlet(value = "/tureupdatecomment.action")
public class TureCommentUpdateServlet extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.요청 데이터 읽기 브라우저에서 전송한 데이터 읽기(boardno)
		String sCommentNo = req.getParameter("commentno");
		int commentNo = Integer.parseInt(sCommentNo);
		String sBoardNo = req.getParameter("boardno");
		String sPageNo = req.getParameter("pageno");
		String sContent = req.getParameter("content");
		
		TureBoardComment comment = new TureBoardComment();
		comment.setCommentNo(commentNo);
		comment.setContent(sContent);
				
		//2.commentno로 데이터 수정(BoardService 사용)
		//조회실패(결과가 null) list.action으로
		TureBoardService boardService = new TureBoardService();
		boardService.updateComment(comment);
		//3. detail.action으로 이동
		resp.sendRedirect(String.format("turedetail.action?boardno=%s&pageno=%s", sBoardNo, sPageNo));
																//boardno(%s)=sBoardNo, pageno(%s)=sPageNo
	}
	
}
