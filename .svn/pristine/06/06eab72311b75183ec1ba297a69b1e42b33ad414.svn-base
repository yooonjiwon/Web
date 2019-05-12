package com.seoul.tureservlet;

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

import com.seoul.dto.TureBoardAttach;
import com.seoul.service.TureBoardService;

@WebServlet(value = "/board/download2.action")
public class TureDownloadServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보에서(detail.jsp)첨부파일 번호 읽기
		String sAttachNo = 
			req.getParameter("attachno");
		int attachNo = 0;
		try{
			attachNo = Integer.parseInt(sAttachNo);
		} catch(Exception e){
			
		}if(attachNo == 0){//attachno가 오류이면 리스트로 돌아감
			resp.sendRedirect("list.action");
			return;
		}
		//attachno로 데이터 조회
		//다운로드 처리
		TureBoardService boardService = new TureBoardService();
		TureBoardAttach attachment = boardService.findBoardAttachByAttachNo(attachNo);
		if(attachment == null){
			resp.sendRedirect("list.action");
			return;
		}
		
		//요청정보에서 다운로드 할 파일 이름 읽기
				//servletcontext : jsp의 application 내장 객체
				ServletContext application =  req.getServletContext();
				String path = application.getRealPath("/WEB-INF/files/"+ attachment.getSavedFileName());
				//다운로드 할 파일 경로를 구성
				//mime type(브라우저에 다운로드를 지시)
//				resp.setContentType("application/octet-stream");
//				resp.addHeader("Content-Disposition", "Attachment;filename=\""+new String(attachment.getUserFileName().getBytes("euc-kr"), "ISO-8859-1")+"\"");
//				
				//다운로드 컨텐츠를 응답스트림에 기록
//				BufferedInputStream  bistream = new BufferedInputStream(new FileInputStream(path));
//				BufferedOutputStream bostream = new BufferedOutputStream(resp.getOutputStream());
//				while (true){
//				int data = bistream.read();
//				if (data == -1) break;
//				bostream.write(data);
//				}
//				bistream.close();
//				bostream.close();
			
		}

		
	}
	

