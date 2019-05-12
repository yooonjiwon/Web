package com.seoul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.common.Util;
import com.seoul.dao.MemberDao;
import com.seoul.dto.Member;

public class LoginController implements Controller{

	public ActionResult processRequest(
			HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		MemberDao dao = new MemberDao();
		Member member = dao.selectMemberByIdAndPasswd(id, passwd);
		
		ActionResult result = new ActionResult();
		if(member == null) {
			result.setUrl("login.action?loginid=" +id);
			result.setRedirect(true);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", member);
			result.setUrl("index.action");
			result.setRedirect(true);
		}
		return result;
		
	}
}
