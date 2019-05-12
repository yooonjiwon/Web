package com.dieat.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dieat.dto.Member;
import com.dieat.mapper.MemberMapper;

@Repository(value = "memberDao")
public class MemberDao {



	@Autowired
	@Qualifier("memberMapper")
	private MemberMapper memberMapper;
	
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}

	public Member selectMemberByIdAndPasswd(String id, String passwd) {

		
		HashMap<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("passwd", passwd);
		
		Member member = memberMapper.selectMemberByIdAndPasswd(params);
		return member;
	}

	public Member selectMemberInfo(String id) {
		
		Member member = memberMapper.selectMemberInfo(id);
		return member;
	}

	public void updateMember(Member member) {
		memberMapper.updateMember(member);
		
	}



}
