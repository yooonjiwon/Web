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
import com.seoul.dto.TureCommenteCount;
import com.seoul.service.TureBoardService;

@WebServlet(value = "/turedeletecomment.action")
public class TureCommentDeleteServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.요청 데이터 읽기 브라우저에서 전송한 데이터 읽기(boardno)
		String sCommentNo = req.getParameter("commentno");
		int commentNo = Integer.parseInt(sCommentNo);
		String sBoardNo = req.getParameter("boardno");
		String sPageNo = req.getParameter("pageno");

				
		//2.commentno로 데이터 삭제(BoardService 사용)
		//조회실패(결과가 null) list.action으로
		TureBoardService boardService = new TureBoardService();
		boardService.deleteComment(commentNo);
		
		TureCommenteCount upcount = (TureCommenteCount)req.getSession().getAttribute("commentcount");
		upcount.setCount(upcount.getCount()-1);
		req.setAttribute("commentcount", upcount);
		
		//3. detail.action으로 이동
		resp.sendRedirect(String.format("turedetail.action?boardno=%s&pageno=%s", sBoardNo, sPageNo));
																//boardno(%s)=sBoardNo, pageno(%s)=sPageNo
	}
	
}
