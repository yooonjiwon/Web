package com.seoul.guideservlet;

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


import com.seoul.dto.GuideBoardComment;
import com.seoul.service.GuideBoardService;

@WebServlet(value ="/seoulmate/updatecomment.action")
public class GuideCommentUpdateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//1.요청 데이터(브라우저에서 전송한 데이터) 읽기
		String sCommentNo = req.getParameter("guc_commentno");
		int guc_CommentNo = Integer.parseInt(sCommentNo);				
		String sBoardNo = req.getParameter("guc_boardno");
		String sPageNo = req.getParameter("pageno");
		String sContent =req.getParameter("guc_content");
		
		//2.commentno로 데이터 변경(boardService 사용)
		GuideBoardComment guideComment = new GuideBoardComment();
		guideComment.setGuc_CommentNo(guc_CommentNo);
		guideComment.setGuc_Content(sContent);
		GuideBoardService guideBoardService = new GuideBoardService();
		guideBoardService.updateComment(guideComment);
		
		
		
		//3.detail.action로 이동
		resp.sendRedirect(String.format("/seoul/seoulmate/detail.action?gub_boardno=%s&pageno=%s", sBoardNo, sPageNo)); 
		
	}
	
}
