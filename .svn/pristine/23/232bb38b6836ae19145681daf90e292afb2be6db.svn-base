package com.dieat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dieat.dao.MemberDao;
import com.dieat.dto.Member;

@Service(value="memberService") //@Component
public class MemberService {


	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;
	
	public void registerMember(Member member) {
		memberDao.insertMember(member);
	}
	
	public Member authenticate(String id, String passwd) {
		Member member = 
				memberDao.selectMemberByIdAndPasswd(id, passwd);
		return member;
	}

	public Member selectMemberInfo(String id) {
		Member member = memberDao.selectMemberInfo(id);
		return member;
	}

	public void editMember(Member member) {
		memberDao.updateMember(member);
		
	}


}
