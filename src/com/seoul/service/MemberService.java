package com.seoul.service;

import com.seoul.dao.MemberDao;
import com.seoul.dto.Member;
import com.seoul.dao.MemberDao;
import com.seoul.dto.Member;

public class MemberService {

	public void registerMember(Member member) { //회원가입 Service
		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
	}

	public Member authenticate(String memberId, String passwd) { //로그인 Service
		MemberDao dao = new MemberDao();
		Member member = dao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
	}

	public int checkDuplicate(String memberId) { //아이디 중복검사 Service
		MemberDao dao = new MemberDao();
		int rst = dao.selectCountByMemberId(memberId);
		return rst;
	}
	
	public void updateMember(Member member) {
		MemberDao memberDao = new MemberDao();
		memberDao.updateMember(member);
	}
	
	public Member findMemberByMemberId(String memberId) {
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.selectMemberByMemberId(memberId);
		return member;
	}	
	
	
}
