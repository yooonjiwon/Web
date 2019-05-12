package com.seoul.tureservlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.seoul.common.Util;
import com.seoul.dto.TureBoard;
import com.seoul.dto.TureBoardAttach;
import com.seoul.dto.TureMember;
import com.seoul.service.TureBoardService;
import com.seoul.service.TureMemberService;

@WebServlet(value = "/turewrite.action")
public class TureBoardWriteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) {
			resp.sendRedirect("/seoul/account/login.action");
			return;
		}	
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/tureboard/turewrite.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 브라우저에서 전송된 데이터 읽기

		/////////////////// 파일업로드 구문//////////////////

		if (ServletFileUpload.isMultipartContent(req) == false) {
			resp.sendRedirect("turelist.action");// lib에 jar형식의 다운로드/다운로드 io파일이 있어야함
			return;
		}
		/////////////////////////////////////////////////////////////////////////////
		// 경로 문자열을 저장할 변수
		// application.getRealPath('웹경로') : 가상경로(웹 경로) -> 물리경로(컴퓨터 경로)
		// http://..... -> C:/.....변경해야할 값
		ServletContext application = req.getServletContext();
		String path = application.getRealPath("/files"); // 최종 파일 저장 경로
		String tempPath = application.getRealPath("/WEB-INF/temp"); // 임시 파일 저장
																	// 경로
		/////////////////////////////////////////////////////////////////////////////
		// 전송데이터를 각 요소별로 분리하여 개별 객체를 만들때 사용할 처리기
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 2);
		factory.setRepository(new File(tempPath));

		// 요청 정보를 읽을 파서(Parser)생성(요청을 읽고 요소별로 분리)
		ServletFileUpload uploader = new ServletFileUpload(factory);
		uploader.setFileSizeMax(1024 * 1024 * 10); // 최대 파일 크기

		// 사용자의 요청 데이터를 Board 객체에 저장
		TureBoard board = new TureBoard();// 1
		ArrayList<TureBoardAttach> attachments = new ArrayList<>();// many

		try {
			// 요청 정보를 파싱하고 개별 객체의 목록을 반환
			List<FileItem> items = uploader.parseRequest(req);// 데이터를 뭉쳐서 한번에 넘김

			for (FileItem item : items) { // 넘어온 데이터를 걸러냄
				if (item.isFormField()) { // form-data인 경우>>넘어오는 데이터중
											// formfield항목을 읽어온다
					if (item.getFieldName().equals("title")) // req.getParameter("title")
					{board.setTitle(item.getString("utf-8"));} 
					else if (item.getFieldName().equals("writer")) 
					{board.setWriter(item.getString("utf-8"));} 
					else if (item.getFieldName().equals("passno")) 
					{board.setPassNo(item.getString("utf-8"));}
					else if (item.getFieldName().equals("content")) 
					{board.setContent(item.getString("utf-8"));}
					else if (item.getFieldName().equals("location")) 
					{board.setLocation(item.getString("utf-8"));}
					else if (item.getFieldName().equals("time")) 
					{board.setTime(item.getString("utf-8"));}
					else if (item.getFieldName().equals("day")) 
					{board.setDay(item.getString("utf-8"));}
					

				} else { // file인 경우

					String fileName = item.getName();// 업로드된 파일이름
					if (fileName != null && fileName.length() > 0) { // 내용이 있는
																		// 경우
						if (fileName.contains("\\")) {
							// C:\AAA\BBB\CCC.png -> CCC.png
							fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						}
						String uniqueFileName = Util.makeUniqueFileName(fileName);
						item.write(new File(path, uniqueFileName)); // 파일 저장
						item.delete(); // 임시 파일 삭제

						TureBoardAttach attachment = new TureBoardAttach();// 하나의 파일을
																	// 저장할공간
						attachment.setUserFileName(fileName);// 파일이름 지정
						attachment.setSavedFileName(uniqueFileName);// 변조해서 저장할
																	// 파일이름
						attachments.add(attachment);// 어레이 리스트 attachments에 추가
					}
				}
			}

		} catch (Exception e) {
e.printStackTrace();
		}
		//////////////////////////////////////////////////////////////////////////////////////////////

		// 사용자 등록 처리
		TureBoardService boardService = new TureBoardService();
		int newBoardNo = boardService.writeBoard(board);
		for (TureBoardAttach attachment : attachments) {
			attachment.setBoardNo(newBoardNo);
			boardService.saveBoardAttach(attachment);
		}
		resp.sendRedirect("/seoul/turelist.action");
	}

}
