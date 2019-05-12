package com.seoul.contactsservlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.seoul.common.Util;
import com.seoul.dto.ContactsAttach;
import com.seoul.dto.ContactsBoard;
import com.seoul.service.ContactsBoardService;

@WebServlet(value ="/contacts/quewrite.action") 
public class QueWriteServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contacts/quewrite.jsp");
			dispatcher.forward(req, resp);
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("utf-8");

			//파일 업로드를 포함한 요청인지 확인 (multipart/form-data 형식 확인)
			if (ServletFileUpload.isMultipartContent(req) == false) {
				resp.sendRedirect("quelist.action");
				return;
			}

			//경로 문자열을 저장할 변수
				//application.getRealPath('웹경로')
			//--> 가상경로(웹경로) -> 물리경로(컴퓨터경로)
			//--> http://..... -> C:/......
			ServletContext application = req.getServletContext();
			String path = application.getRealPath("/WEB-INF/files");//최종 파일 저장 경로
			String tempPath = application.getRealPath("/WEB-INF/temp");//임시 파일 저장 경로

			//전송 데이터 각 요소를 분리해서 개별 객체를 만들때 사용할 처리기
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024 * 2);
			factory.setRepository(new File(tempPath));

			//요청 정보를 읽을 파서(Parser) 생성 (요청을 읽고 요소별로 분리)
			ServletFileUpload uploader = new ServletFileUpload(factory);
			uploader.setFileSizeMax(1024 * 1024 * 10);//최대 파일 크기

			//사용자의 요청 데이터를 Board 객체에 저장
			ContactsBoard board = new ContactsBoard(); //1
			ArrayList<ContactsAttach> attachments = new ArrayList<>();//many
			
			
			try {
				//요청 정보를 파싱하고 개별 객체의 목록을 반환
				List<FileItem> items = uploader.parseRequest(req);
		
				for (FileItem item : items) {
					if (item.isFormField()) { //form-data인 경우
						if (item.getFieldName().equals("title")) {//req.getParameter("title")
							board.setTitle(item.getString("utf-8"));
						} else if (item.getFieldName().equals("writer")) {
							board.setWriter(item.getString("utf-8"));
						} else if (item.getFieldName().equals("content")) {
							board.setContent(item.getString("utf-8"));
						} else if (item.getFieldName().equals("password")) {
							board.setPassword(item.getString("utf-8"));
						}
					} else { //file인 경우
						String fileName = item.getName();//업로드된 파일 이름
						if (fileName != null && fileName.length() > 0) { //내용이 있는 경우
							if (fileName.contains("\\")) {
								//C:\AAA\BBB\CCC.png -> CCC.png
								fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
							}
							String uniqueFileName = Util.makeUniqueFileName(fileName);
							item.write(new File(path, uniqueFileName)); //파일 저장
							item.delete(); //임시 파일 삭제
							
							ContactsAttach attachment = new ContactsAttach();
							attachment.setUserFileName(fileName);
							attachment.setSavedFileName(uniqueFileName);
							attachments.add(attachment);
						}
					}
				}
			
			} catch (Exception ex) {			
			}
			
			//게시글 등록 처리
			ContactsBoardService boardService = new ContactsBoardService();
			int newBoardNo = boardService.writeBoard3(board);
			for (ContactsAttach attachment : attachments) {
				attachment.setBoardNo(newBoardNo);
				boardService.saveBoardAttach(attachment);
			}

			resp.sendRedirect("quelist.action");
		}
		
		
	}
		
