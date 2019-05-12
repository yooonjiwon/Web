package com.seoul.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.Member;

@WebFilter(value = "*.action") //action으로(서블릿)향하는 모든 요청에 대해
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	
	
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
	
		//인증(로그인여부)필터 생성{ServletRequest,ServletResponse은 모든 서블릿에 관한 필터이기 때문에 Http에 관한것만 따로정의}
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
	
		
		String uri = req.getRequestURI();
		if (uri.contains("/seoulmate/")) { //경로에 board를 가지고있고 
		//if (uri.contains("/list.action") == false) { //목록 페이지가 아닌 경우
			if (!uri.contains("/list.action")) { //목록 페이지가 아닌 경우(위 문장과 같은 의미)
				//인증체크(로그인확인)를 해야한다
				HttpSession session = req.getSession();
				Member member = (Member)session.getAttribute("loginuser");
				if (member == null) { //로그인하지 않은 경우 로그인화면으로 이동
					resp.sendRedirect("/seoul/account/login.action");
					return;
				}
			}
		}
		
		if (uri.contains("/contacts/")) { //경로에 contacts를 가지고있고 
			if (!uri.contains("/contactslist.action")) {
				if(!uri.contains("/contactsdetail.action")) {
					if(!uri.contains("/contactssearch.action")) {
						if(!uri.contains("/eventlist.action")) {
							if(!uri.contains("/eventdetail.action")) {
								if(!uri.contains("/eventsearch.action")) {
									if(!uri.contains("/quelist.action")) {
										if(!uri.contains("/quedetail.action")) {
											if(!uri.contains("/quesearch.action")) {
												if(!uri.contains("/afterlist.action")) {
													if(!uri.contains("/afterdetail.action")) {
														if(!uri.contains("/aftersearch.action")) {
															HttpSession session = req.getSession();
															Member member = (Member)session.getAttribute("loginuser");
															if (member == null) { //로그인하지 않은 경우 로그인화면으로 이동
																resp.sendRedirect("/seoul/account/login.action");
																return;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		
			
			
		
		if (uri.contains("/information/")) { //경로에 board를 가지고있고 
		//if (uri.contains("/list.action") == false) { //목록 페이지가 아닌 경우
			if (!uri.contains("/home3.action")) { //목록 페이지가 아닌 경우(위 문장과 같은 의미)
				if (!uri.contains("/list3.action")) {
					if (!uri.contains("/detail3.action")) {
						if (!uri.contains("/list32.action")) {
							if (!uri.contains("/detail32.action")) {
								if (!uri.contains("/list33.action")) {
									if (!uri.contains("/detail33.action")) {
										if (!uri.contains("/list34.action")) {
											if (!uri.contains("/detail34.action")) {
												if (!uri.contains("/list35.action")) {
													if (!uri.contains("/detail35.action")) {
														if (!uri.contains("/list36.action")) {
															if (!uri.contains("/detail36.action")) {
																if (!uri.contains("/list37.action")) {
																	if (!uri.contains("/detail37.action")) {
																		if (!uri.contains("/list38.action")) {
																			if (!uri.contains("/detail38.action")) {
																
				//인증체크(로그인확인)를 해야한다
					HttpSession session = req.getSession();
					Member member = (Member)session.getAttribute("loginuser");
					if (member == null) { //로그인하지 않은 경우 로그인화면으로 이동
						resp.sendRedirect("/seoul/account/login.action");
						return;
																				}
																			}
																		}
																	}
																}
															}	
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		arg2.doFilter(req, resp);
		
		
		
		
	}


	
	
	
	@Override
	public void destroy() {}
}
