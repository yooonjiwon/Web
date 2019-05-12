package com.seoul.contactsservlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.dto.ContactsAttach;
import com.seoul.service.ContactsBoardService;

@WebServlet(value = "/contacts/downloads.action")
public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//요청 정보에서 첨부파일 번호 읽기
		String sAttachNo = req.getParameter("attachno");
		int attachNo = 0;
		try {
			attachNo = Integer.parseInt(sAttachNo);
		} catch (Exception ex) { }
		if (attachNo == 0) {
			resp.sendRedirect("contactslist.action");
			return;
		}
		
		//attachNo로 데이터 조회
		ContactsBoardService boardService = new ContactsBoardService();
		ContactsAttach attachment = 
				boardService.findBoardAttachByAttachNo(attachNo);
		if (attachment == null) {
			resp.sendRedirect("contactslist.action");
			return;
		}
		
		//다운로드 처리
		//ServletContext : JSP의 application 내장 객체
		ServletContext application = req.getServletContext();
		//다운로드할 파일의 경로 구성
		String path = application.getRealPath(
				"/WEB-INF/files/" + attachment.getSavedFileName());
		
		//브라우저에게 다운로드 지시 설정
		resp.setContentType("application/octet-stream");
		resp.addHeader("Content-Disposition", 
				"Attachment;filename=\"" + 
				new String(attachment.getUserFileName().getBytes("euc-kr"), "ISO-8859-1") + 
				"\"");
		
		//다운로드 컨텐츠를 응답스트림에 기록
		BufferedInputStream bistream = 
				new BufferedInputStream(new FileInputStream(path));
		BufferedOutputStream bostream = 
				new BufferedOutputStream(resp.getOutputStream());
		while (true) {
			int data = bistream.read();			
			if (data == -1) break; //EOF (end of file)			
			bostream.write(data);
		}
		
		bistream.close();
		bostream.close();
	}
	
}