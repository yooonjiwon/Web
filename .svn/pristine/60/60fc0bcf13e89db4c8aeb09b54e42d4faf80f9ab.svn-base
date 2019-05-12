package com.seoul.service;

import com.seoul.dao.TourMemberDao;
import com.seoul.dto.TureCommenteCount;
import com.seoul.dto.TureMember;

public class TureMemberService {

	public void registerMember(TureMember member) {
		//처리해야할 내용이 있는 경우 구현 ...
		TourMemberDao memberDao = new TourMemberDao();
		memberDao.insertMember(member);
	}

	public TureMember authenticate(String memberId, String passwd) {
		TourMemberDao dao = new TourMemberDao();
		TureMember member = 
				dao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
	}

	public TureCommenteCount readcount(String memberId) {
		TourMemberDao dao = new TourMemberDao();
		TureCommenteCount count = 
				dao.readCount(memberId);
		return count;
	}

}
