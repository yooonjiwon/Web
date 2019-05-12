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

@WebServlet(value ="/seoulmate/writee.action") 
public class GuideWriteServlet2 extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/seoulmate/guidesubmit.jsp");
			dispatcher.forward(req, resp);
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			
			String sBoardNo = req.getParameter("gub_boardno");
			if (sBoardNo == null) {
				sBoardNo = "0";
			}
			int gub_BoardNo = Integer.parseInt(sBoardNo);
			
			/*String sBoardNo = req.getParameter("boardno");
			int gub_BoardNo = Integer.parseInt(sBoardNo);*/
			
			String gub_Title = req.getParameter("gub_title");
			String gub_Writer = req.getParameter("gub_writer");
			String gub_Intro = req.getParameter("gub_intro");
			
			Guide guide = new Guide();
			guide.setGub_BoardNo(gub_BoardNo);
			guide.setGub_Title(gub_Title);
			guide.setGub_Writer(gub_Writer);
			guide.setGub_Intro(gub_Intro);
			
			
			GuideBoardService guideBoardService = new GuideBoardService();
			guideBoardService.writeBoard(guide);
			
			
			resp.sendRedirect("/seoul/seoulmate/list.action");
			
			}
			
		}
		

