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
import com.seoul.dto.GuideSub;
import com.seoul.service.GuideBoardService;
import com.seoul.service.GuideSubService;

@WebServlet(value ="/seoulmate/submit.action") 
public class GuideSubmitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seoulmate.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		String sub_Copies1 = req.getParameter("sub_copies1");
		String sub_Copies2 = req.getParameter("sub_copies2");
		String sub_Writer = req.getParameter("sub_writer");
		String sub_Email = req.getParameter("sub_email");
		String sub_Phone = req.getParameter("sub_phone");
		String sub_Addr1 = req.getParameter("sub_addr1");
		String sub_Addr2 = req.getParameter("sub_addr2");
		String sub_Cause = req.getParameter("sub_cause");
		
		GuideSub guideSub = new GuideSub();
		guideSub.setSub_Copies1(sub_Copies1);
		guideSub.setSub_Copies2(sub_Copies2);
		guideSub.setSub_Writer(sub_Writer);
		guideSub.setSub_Email(sub_Email);
		guideSub.setSub_Phone(sub_Phone);
		guideSub.setSub_Addr1(sub_Addr1);
		guideSub.setSub_Addr2(sub_Addr2);
		guideSub.setSub_Cause(sub_Cause);
		
		GuideSubService guideSubService = new GuideSubService();
		guideSubService.subBoard(guideSub);
		
		
		resp.sendRedirect("/seoul/seoulmate/list.action");
		
		}
		
	}
		

