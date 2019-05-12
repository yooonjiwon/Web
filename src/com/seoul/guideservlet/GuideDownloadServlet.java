package com.seoul.guideservlet;

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

import com.seoul.dto.GuideBoardAttach;
import com.seoul.dto.GuideFile;
import com.seoul.service.FileService;
import com.seoul.service.GuideBoardService;

@WebServlet(value ="/seoulmate/filedownload.action")
public class GuideDownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청정보에서 첨부파일 번호 읽기
		String sFileNo = req.getParameter("file_no");
		int file_no = 0;
		try {
			file_no = Integer.parseInt(sFileNo);
		} catch (Exception ex) {
		}
		if (file_no == 0) {
			resp.sendRedirect("list.action");
			return;
		}
		
		//attachNo로 데이터 조회
		FileService fileService = new FileService();
		GuideFile guideFile = fileService.findFileNo(file_no);
		if (guideFile == null) { //다운로드할 파일이 없으면 리스트로 돌아감
			resp.sendRedirect("list.action");
			return;
		}
		
				//다운로드 처리
		
				//ServletContext : JSP의 application 내장 객체
				ServletContext application = req.getServletContext();
				
				
				//다운로드할 파일의 경로 구성							
														/*여기는 다운로드할 파일 이름을 가져오고*/
				String path = application.getRealPath("/WEB-INF/files/" + guideFile.getFile_SavedName());
				
				
				//mime타입(최초에email에서 파일첨부를 위해 사용되었던 형식.(text/html, image/jpg, application/octet-stream...등등의 형식)
				//브라우저에게 직접 처리할수 없으니 다운로드를 하라고 지시하는 설정
				resp.setContentType("application/octet-stream");
				
				//다운로드 창에 나타나는 정보(ex> 브라우저에서 이미지 다른이름으로 저장했을때 뜨는 창의 정보)
				resp.addHeader("Content-Disposition", "Attachment;filename=\"" + 
								new String(guideFile.getFile_SavedName().getBytes("euc-kr"), "ISO-8859-1") + "\"");
													  /*여기는 유저에게 보여줄 파일 이름을 가져온다*/
				
				//다운로드 컨텐츠를 응답스트림에 기록
				BufferedInputStream bistream = new BufferedInputStream(new FileInputStream(path)); //파일을 읽어서
				BufferedOutputStream bostream = new BufferedOutputStream(resp.getOutputStream());  //응답스트림에 기록
				while (true) {
					int data = bistream.read();
					if (data == -1) break; //EOF(End of file)
					bostream.write(data);
				}
				
				bostream.close();
				bostream.close();
		
		
		
	}
}
