package com.seoul.service;

import java.util.ArrayList;
import java.util.List;

import com.seoul.dao.ContactsBoardDao;
import com.seoul.dto.ContactsAttach;
import com.seoul.dto.ContactsBoard;
import com.seoul.dto.ContactsComment;

public class ContactsBoardService {

	public List<ContactsBoard> findBoardList() {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		List<ContactsBoard> boards = boardDao.selectBoard();
		return boards;
	}

	public ContactsBoard findBoardByBoardNo(int boardNo) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		ContactsBoard board = boardDao.selectBoardByBoardNo(boardNo);
		
		ArrayList<ContactsAttach>	attachments =	boardDao.selectBoardAttachByBoardNo(boardNo);
		board.setAttachments(attachments);
		
		ArrayList<ContactsComment> comments = 	boardDao.selectCommentByBoardNo(boardNo);
		board.setComments(comments);
		
		return board;
	}
	
	public List<ContactsBoard> findBoardList1(int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList1(first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList2(int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList2(first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList3(int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList3(first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList4(int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList4(first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList5(String search1, String search2, int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList5(search1, search2, first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList6(String search1, String search2, int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList6(search1, search2, first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList7(String search1, String search2, int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList7(search1, search2, first, last);
		return boards;
	}
	
	public List<ContactsBoard> findBoardList8(String search1, String search2, int first, int last) {
		ContactsBoardDao dao = new ContactsBoardDao();
		List<ContactsBoard> boards = dao.selectBoardList8(search1, search2, first, last);
		return boards;
	}

	
	public int getBoardCount1() {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount1();
		return count;
	}
	
	public int getBoardCount2() {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount2();
		return count;
	}
	
	public int getBoardCount3() {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount3();
		return count;
	}
	
	public int getBoardCount4() {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount4();
		return count;
	}
	
	public int getBoardCount5(String search1, String search2) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount5(search1, search2);
		return count;
	}
	
	public int getBoardCount6(String search1, String search2) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount6(search1, search2);
		return count;
	}
	
	public int getBoardCount7(String search1, String search2) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount7(search1, search2);
		return count;
	}
	
	public int getBoardCount8(String search1, String search2) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int count = dao.getBoardCount8(search1, search2);
		return count;
	}
	
	public void increaseReadCount(int boardNo) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		boardDao.updateReadCount(boardNo);		
	}
	
	public void updateBoard(ContactsBoard board) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		boardDao.updateBoard(board);
		
	}
	
	public int writeBoard1(ContactsBoard board) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int newBoardNo = dao.insertBoard1(board);
		return newBoardNo;
	}

	public int writeBoard2(ContactsBoard board) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int newBoardNo = dao.insertBoard2(board);
		return newBoardNo;
		
	}
	
	public int writeBoard3(ContactsBoard board) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int newBoardNo = dao.insertBoard3(board);
		return newBoardNo;
		
	}
	
	public int writeBoard4(ContactsBoard board) {
		ContactsBoardDao dao = new ContactsBoardDao();
		int newBoardNo = dao.insertBoard4(board);
		return newBoardNo;
		
	}
	
	public void deleteBoard(int boardNo) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		boardDao.deleteBoard(boardNo);		
	}
	
	public void writeComment(ContactsComment comment) {
		ContactsBoardDao dao = new ContactsBoardDao();
		dao.insertComment(comment);
	}

	public void saveBoardAttach(ContactsAttach attachment) {
		ContactsBoardDao dao = new ContactsBoardDao();
		dao.insertBoardAttach(attachment);		
	}

	public void replyBoard1(ContactsBoard board) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		//원 글의 정보 조회
		ContactsBoard parent = boardDao.selectBoardByBoardNo(board.getBoardNo());
		
		//같은 그룹에 포함된 기존 글의 순서번호(step) 증가
		boardDao.updateStep(parent.getGroupNo(), parent.getStep());
		
		board.setGroupNo(parent.getGroupNo());
		board.setStep(parent.getStep() + 1);
		board.setDepth(parent.getDepth() + 1);
		boardDao.insertReply1(board);		
		
	}
	
	public void replyBoard2(ContactsBoard board) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		//원 글의 정보 조회
		ContactsBoard parent = boardDao.selectBoardByBoardNo(board.getBoardNo());
		
		//같은 그룹에 포함된 기존 글의 순서번호(step) 증가
		boardDao.updateStep(parent.getGroupNo(), parent.getStep());
		
		board.setGroupNo(parent.getGroupNo());
		board.setStep(parent.getStep() + 1);
		board.setDepth(parent.getDepth() + 1);
		boardDao.insertReply2(board);		
		
	}
	
	public void replyBoard3(ContactsBoard board) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		//원 글의 정보 조회
		ContactsBoard parent = boardDao.selectBoardByBoardNo(board.getBoardNo());
		
		//같은 그룹에 포함된 기존 글의 순서번호(step) 증가
		boardDao.updateStep(parent.getGroupNo(), parent.getStep());
		
		board.setGroupNo(parent.getGroupNo());
		board.setStep(parent.getStep() + 1);
		board.setDepth(parent.getDepth() + 1);
		boardDao.insertReply3(board);		
		
	}
	
	public void replyBoard4(ContactsBoard board) {
		ContactsBoardDao boardDao = new ContactsBoardDao();
		//원 글의 정보 조회
		ContactsBoard parent = boardDao.selectBoardByBoardNo(board.getBoardNo());
		
		//같은 그룹에 포함된 기존 글의 순서번호(step) 증가
		boardDao.updateStep(parent.getGroupNo(), parent.getStep());
		
		board.setGroupNo(parent.getGroupNo());
		board.setStep(parent.getStep() + 1);
		board.setDepth(parent.getDepth() + 1);
		boardDao.insertReply4(board);		
		
	}

	public ContactsAttach findBoardAttachByAttachNo(int attachNo) {
		ContactsBoardDao dao = new ContactsBoardDao();
		ContactsAttach attachment = 
				dao.selectBoardAttachByAttachNo(attachNo);
		return attachment;
	}

	public void updateComment(ContactsComment comment) {
		ContactsBoardDao dao = new ContactsBoardDao();
		dao.updateComment(comment);
	}

	public void deleteComment(int commentNo) {
		ContactsBoardDao dao = new ContactsBoardDao();
		dao.deleteComment(commentNo);
		
	}

	public String checkPassword(int boardNo) {
		ContactsBoardDao dao = new ContactsBoardDao();
		String password = dao.checkPassword(boardNo);
		return password;
	}
	

}
