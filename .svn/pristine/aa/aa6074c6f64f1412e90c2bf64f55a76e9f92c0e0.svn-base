package com.seoul.guideservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.dto.GuideBoardComment;
import com.seoul.dto.Member;
import com.seoul.service.GuideBoardService;

@WebServlet(value ="/seoulmate/writecomment.action")
public class GuideCommentWriteServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//브라우저에서 전송된 요청 데이터 읽기
		String sBoardNo = req.getParameter("guc_boardno");
		int guc_BoardNo = Integer.parseInt(sBoardNo);
		String sPageNo = req.getParameter("pageno");
		int pageNo = Integer.parseInt(sPageNo);
		String guc_Content = req.getParameter("guc_content");
		/*String guc_Writer = req.getParameter("guc_writer");*/
						
		//데이터베이스에 데이터 저장
		GuideBoardComment guideBoardComment = new GuideBoardComment();
		guideBoardComment.setGuc_BoardNo(guc_BoardNo);
		guideBoardComment.setGuc_Content(guc_Content);	
		//현재 로그인한 사용자id를 writer로 지정  
		Member member = (Member)req.getSession().getAttribute("loginuser");
		guideBoardComment.setGuc_Writer(member.getMemberId());
		
		GuideBoardService guideBoardService = new GuideBoardService();
		guideBoardService.writeComment(guideBoardComment);
		
		
		//이동 sBoardNo,sPageNo를 넘겨줌, String.format문자열과 데이터를 함께 쓸때 사용
		resp.sendRedirect(String.format("detail.action?gub_boardno=%s&pageno=%s", sBoardNo, sPageNo));
		
	}
	
}
