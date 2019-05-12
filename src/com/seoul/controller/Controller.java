package com.seoul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Action Controller가 구현해야할 인터페이스<br>
 * 요청 처리 기능을 수행할 method 포함
 * @author 지원
 *
 */
public interface Controller {

	ActionResult processRequest(HttpServletRequest req, HttpServletResponse resp);
	
}
