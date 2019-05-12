
package com.seoul.guideservlet;
 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.seoul.common.Util;
import com.seoul.dto.Guide;
import com.seoul.dto.GuideFile;
import com.seoul.service.FileService;
import com.seoul.service.GuideBoardService; 
/**
 * Servlet implementation class Upload
 */
@WebServlet("/seoulmate/file.action")
public class GuideFileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// 늘 언제라도 문자셋을 설정해준다.
		//request.setCharacterEncoding("UTF-8");

		// 파일 업로드 => 클라이언트가 선택한 파일을 서버의 하드디스크에 복사하는 기능
		// 이러한 기능을 수행 하려면 알아햐 하는 것들
		// 1. 목적지(어디로 복사할 것인지) 경로 설정
		// 현재 웹어플리케이션을 기준으로 upload폴더를 만들어 두었다.
		// 실제 경로는 request 를 통해서 알아온다.
		
		ServletContext application = request.getServletContext();
		String path = application.getRealPath("/WEB-INF/files"); //path 는 파일을 업로드하면 실제로 최종파일이 저장될 경로
		String tempPath = application.getRealPath("/WEB-INF/temp");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 5); //setSizeThreshold : 임시파일을 만드는 사이즈의 경계선,바이트단위로 지정
		factory.setRepository(new File(tempPath));
		
		ServletFileUpload uploader = new ServletFileUpload(factory);
		uploader.setFileSizeMax(1024 * 1024 * 30);
		

		//System.out.println("path:"+ path);
		// 결과 ==> 
		//path :C:\jspStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\day0412밑에upload 

		//파일경로가 잘 생성되는지 확인하기 위해 만들어 놓음
		// 또한 현재 저 밑에 else에 해당하는 문서가 없기에 문자를 쓰기 위해 사용
		// request.setCharacterEncoding("UTF-8"); 이렇게 따로하던것을 
		// 밑에처럼 response.setContentType("text/html;UTF-8"); 이렇게 사용해도 무방하다.
		//out.println("path :"+ path);

		
		Guide guide = new Guide();
		ArrayList<GuideFile> guideFiles = new ArrayList<>();
		try {
			List<FileItem> items = uploader.parseRequest(request);
				
			for(FileItem item : items) {
				String fileName = item.getName();
				if (fileName != null && fileName.length() > 0) {
					if (fileName.contains("\\")) {
					fileName = fileName.substring(fileName.lastIndexOf("\\") +1);
				} 
				
					String uniqueFileName = Util.makeUniqueFileName(fileName);
					item.write(new File(path, uniqueFileName)); //파일을 저장
					item.delete(); //임시파일삭제
					
					/* 파일이 하나 만들어질때마다 attach 생성 */
					GuideFile guideFile = new GuideFile();
					guideFile.setFile_UserName(fileName);
					guideFile.setFile_SavedName(uniqueFileName);
					guideFiles.add(guideFile);
					
				}
			}
		
		
	} catch (Exception ex) {
	}
	 
		
		for (GuideFile guideFile : guideFiles) {
			FileService fileService = new FileService();
			fileService.insertFile(guideFile);
		}
		
		
		
		
		
		response.sendRedirect("/seoul/seoulmate/list.action");
		

		}

	}


 

