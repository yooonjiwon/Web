package com.seoul.guideservlet;

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

import com.seoul.dto.Guide;
import com.seoul.service.GuideBoardService;

@WebServlet(value ="/seoulmate/write.action") 
public class GuideWriteServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/seoulmate/guidewrite.jsp");
			dispatcher.forward(req, resp);
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			
			
			
/*			String sBoardNo = req.getParameter("gub_boardno");
			if (sBoardNo == null) {
				sBoardNo = "0";
			}
			int gub_BoardNo = Integer.parseInt(sBoardNo);
			
			String sBoardNo = req.getParameter("boardno");
			int gub_BoardNo = Integer.parseInt(sBoardNo);*/
			
			
			

			String gub_Writer = req.getParameter("gub_writer");
			String gub_Name = req.getParameter("gub_name");
			String gub_Email = req.getParameter("gub_email");
			String gub_PassNo = req.getParameter("gub_passno");
			String gub_Phone = req.getParameter("gub_phone");
			String gub_Title = req.getParameter("gub_title");
			String gub_Intro = req.getParameter("gub_intro");
			String gub_HopeArea = req.getParameter("gub_hopearea");
			String gub_Nation = req.getParameter("gub_nation");
			String gub_Target = req.getParameter("gub_target");
			
			Guide guide = new Guide();
			guide.setGub_Writer(gub_Writer);
			guide.setGub_Name(gub_Name);
			guide.setGub_Email(gub_Email);
			guide.setGub_PassNo(gub_PassNo);
			guide.setGub_Phone(gub_Phone);
			guide.setGub_Title(gub_Title);
			guide.setGub_Intro(gub_Intro);
			guide.setGub_HopeArea(gub_HopeArea);
			guide.setGub_Nation(gub_Nation);
			guide.setGub_Target(gub_Target);
			
			
			GuideBoardService guideBoardService = new GuideBoardService();
			guideBoardService.writeBoard(guide);
			
			
			resp.sendRedirect("/seoul/seoulmate/list.action");
			}
			
		}
		

