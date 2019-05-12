package com.seoul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 요청이 index.action일 때 처리할 Action Controller 클래스<br>
 * Controller interface구현
 * @author jiwon
 */

public class HomeController implements Controller {

	@Override
	public ActionResult processRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		ActionResult result = new ActionResult();
		result.setUrl("index.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
	
}
