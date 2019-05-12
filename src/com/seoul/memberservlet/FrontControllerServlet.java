package com.seoul.memberservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoul.controller.ActionResult;
import com.seoul.controller.Controller;
import com.seoul.controller.ControllerFactory;
import com.seoul.controller.HomeController;
import com.seoul.controller.LoginController;

public class FrontControllerServlet extends HttpServlet{

	ControllerFactory factory;
	
	@Override
	public void init(ServletConfig config) throws ServletException { //init이 호출되어 factory에 자동으로 instance생성
		//서블릿 설정에 저장된 <init-param>정보를 읽기 
		String mappingFilePath = config.getInitParameter("path");
		ServletContext application = config.getServletContext();
		String path = application.getRealPath("/WEB-INF/mappings.properties");
		//getRealPath: 웹의 경로를 실제 경로로 바꾸어준다.
		application.getRealPath(mappingFilePath);
		factory = new ControllerFactory(path);
	}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1. 요청 분석
	String uri = req.getRequestURI();
	int idx = uri.lastIndexOf("/");
	uri = uri.substring(idx);
	idx = uri.indexOf(".");
	String action = uri.substring(1, idx);
	
	//2. 처리기 선택 + 호출
	
	Controller controller = factory.getInstance(action); //controller라는 인터페이스만 들어있어 의존성x
	ActionResult result = controller.processRequest(req, resp);
	
	//3. 응답 결과에 따라 view 선택, 호출
	if (result.isRedirect()) {
		resp.sendRedirect(result.getUrl());
	} else {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INT/views/" + result.getUrl());
		dispatcher.forward(req, resp);	
	}
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	doGet(req, resp);
	}
}
