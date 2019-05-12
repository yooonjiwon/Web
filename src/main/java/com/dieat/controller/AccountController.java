package com.dieat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dieat.common.Util;
import com.dieat.dao.MemberDao;
import com.dieat.dto.Member;
import com.dieat.service.MemberService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	
	@RequestMapping(value = "login.action", method = RequestMethod.GET)
	public String loginForm() {
		
		return "account/modal"; //ViewName 반환 - /WEB-INF/views/ + ViewName + .jsp
	}
	
	
	@RequestMapping(value = "login.action", method = RequestMethod.POST)
	public String login(String id, String passwd, HttpSession session) {		
		
		//1. id, passwd 요청 데이터 읽기 (생략 - 전달인자로 대체)

		passwd = Util.getHashedString(passwd, "SHA-256");
		
		//2. DB에서 데이터 조회 (Model 객체 사용)		
		Member member = memberService.authenticate(id, passwd);
		//3. 결과에 따라 로그인 처리 및 이동
		if (member == null) { //로그인 실패
			return "redirect:login.action";
		} else { //로그인 성공
			session.setAttribute("loginuser", member);
			return "redirect:/home.action";
		}		
	}
	
	@RequestMapping(value = "logout.action", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();	//모든 세션 데이터 삭제
		//session.removeAttribute("loginuser"); //loginuser 데이터 삭제
		
		return "redirect:/home.action";
	}
	
	
	@RequestMapping(value = "register.action", method = RequestMethod.GET)
	public String registerForm() {		
		return "account/register";
	}
	
	@RequestMapping(value = "register.action", method = RequestMethod.POST)
	public String register(Member member) {		
		member.setPasswd(
				Util.getHashedString(member.getPasswd(), "SHA-256"));
		memberService.registerMember(member);
		
		return "redirect:/home.action";
				
	}
	
	@RequestMapping(value = "mypage.action", method = RequestMethod.GET)
	public String mypage() {		
		return "account/mypage";
	}
	
	@RequestMapping(value = "loginconfirm.action", method = RequestMethod.GET)
	public String loginConfirm() {		
		
		return "account/loginconfirm";
	}
	
	@RequestMapping(value = "loginconfirmform.action", method = RequestMethod.POST)
	public String loginConfirmForm(String id, String passwd, HttpSession session, Model model) {	
		
		passwd = Util.getHashedString(passwd, "SHA-256");
		Member member = memberService.authenticate(id, passwd);
		if (member == null) { //로그인 실패
			return "redirect:loginconfirm.action";
		} else { //로그인 성공
			session.setAttribute("loginuser", member);
			Member members = memberService.selectMemberInfo(id);
			model.addAttribute("member", members);
		return "account/mypagedetail";
	}
	}

	
	@RequestMapping(value = "editmember.action", method = RequestMethod.POST)
	public String editMember(Member member) {	
		
		member.setPasswd(
				Util.getHashedString(member.getPasswd(), "SHA-256"));
		System.out.println(member.getPasswd());
		System.out.println(member.getId());
		memberService.editMember(member);
		
		return "account/mypage";
	}
	
}
	








