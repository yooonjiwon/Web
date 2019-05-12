package com.seoul.service;

import java.util.ArrayList;
import java.util.List;

import com.seoul.dao.MemberDao;
import com.seoul.dao.TourBoardDao;
import com.seoul.dao.TourMemberDao;
import com.seoul.dto.Member;
import com.seoul.dto.TureBoard;
import com.seoul.dto.TureBoardAttach;
import com.seoul.dto.TureBoardComment;
import com.seoul.dto.TureMember;

public class TureBoardService {

	public int writeBoard(TureBoard board) {
		// 처리해야할 내용이 있는 경우 구현 ...
		TourBoardDao boardDao = new TourBoardDao();
		int newBoardNo =  boardDao.insertBoard(board);
		return newBoardNo;//생성된 글에서 boardno를 반환
	}

	public List<TureBoard> findBoardList() {
		TourBoardDao boardDao = new TourBoardDao();
		List<TureBoard> boards = boardDao.selectBoard();
		return boards;
	}

	public TureBoard findBoardByBoardNo(int boardNo) {//boardNo로 디테일 조회할때, 첨부파일도 함께 조회
		TourBoardDao boardDao = new TourBoardDao();
		TureBoard board = boardDao.selectBoardByBoardNo(boardNo);
		ArrayList<TureBoardAttach> attachments = boardDao.selectBoardAttachByBoardNo(boardNo);//boardNo를 이용해서 Arraylist조회
		board.setAttachments(attachments);
		ArrayList<TureBoardComment> comments = boardDao.selectCommentByBoardNo(boardNo);
		board.setComments(comments);
		return board;
	}

	public void UpdateBoard(TureBoard board) {
		TourBoardDao boardDao = new TourBoardDao();

		boardDao.updateBoard(board);

	}

	public void deleteBoard(int boardNo) {
		TourBoardDao boardDao = new TourBoardDao();
		boardDao.deleteBoardComment(boardNo);
		boardDao.deleteBoardAttach(boardNo);
		boardDao.deleteBoard(boardNo);
		

	}

	public void increaseReadCount(int boardNo) {
		TourBoardDao boardDao = new TourBoardDao();

		boardDao.updateReadCount(boardNo);
		
	}

	public void replyBoard(TureBoard board) {
		TourBoardDao boardDao = new TourBoardDao();
		
		TureBoard parent = boardDao.selectBoardByBoardNo(board.getBoardNo());//원글의 정보 조회
		//같은 그룹에 포함된 기존 글의 순서번호 증가
		boardDao.updateStep(parent.getGroupNo(), parent.getStep());
		
		board.setGroupNo(parent.getGroupNo());
		board.setStep(parent.getStep()+1);
		board.setDepth(parent.getDepth()+1);
		boardDao.insertReply(board);
	
		
	}

	public List<TureBoard> findBoardList(int first, int last) {
		TourBoardDao dao = new TourBoardDao();
//		List<Board> boards = dao.selectBoard();
		List<TureBoard> boards = dao.selectBoardList2(first, last);
		for (TureBoard board : boards) {
			ArrayList<TureBoardAttach> attachments = dao.selectBoardAttachByBoardNo(board.getBoardNo());
			board.setAttachments(attachments);
		}
		
		return boards;
	}
	
	public List<TureBoardAttach> findBoardAttachList() {
		TourBoardDao dao = new TourBoardDao();
//		
		List<TureBoardAttach> boardattachs = dao.selectBoardAttachList();
		return boardattachs;
	}
	
	public int getBoardCount() {
		TourBoardDao dao = new TourBoardDao();
		int count = dao.getBoardCount();
		return count;
	}

	public void saveBoardAttach(TureBoardAttach attachment) {
		TourBoardDao dao = new TourBoardDao();
		dao.insertBoardAttach(attachment);//용어변경sava>>insert
		
	}

	public TureBoardAttach findBoardAttachByAttachNo(int attachNo) {
		TourBoardDao dao = new TourBoardDao();
		TureBoardAttach attachment = dao.selectBoardAttachByAttachNo(attachNo);//용어변경sava>>insert
		return attachment;
		
	}

	public void writeComment(TureBoardComment comment) {
		TourBoardDao dao = new TourBoardDao();
		dao.insertComment(comment);
		
	}

	public void deleteComment(int commentNo) {
		TourBoardDao dao = new TourBoardDao();
		dao.deleteComment(commentNo);
	}

	public void updateComment(TureBoardComment comment) {
		TourBoardDao dao = new TourBoardDao();
		dao.updateComment(comment);
		
	}

	public List<TureBoard> findMyCheckBoardList(String memberId) {
		TourBoardDao dao = new TourBoardDao();
//		List<Board> boards = dao.selectBoard();
		List<TureBoard> boards = dao.selectMyCheckBoardList(memberId);
		for (TureBoard board : boards) {
			ArrayList<TureBoardAttach> attachments = dao.selectBoardAttachByBoardNo(board.getBoardNo());
			board.setAttachments(attachments);
		}
		
		return boards;
	}

	public Member findGuideProfileByMemberId(String guideId) {
		TourBoardDao dao = new TourBoardDao();
		Member guideProfile = TourBoardDao.selectMemberByGuideId(guideId);
		
		return guideProfile;
	}

	public void insertGuideId(Member member) {
		TourBoardDao dao = new TourBoardDao();
		dao.insertGuide(member);
		dao.insertTurlist(member);

	}

	public TureBoard findMyConnection(String memberId) {
		TourBoardDao dao = new TourBoardDao();
		TureBoard connection = dao.findConnection(memberId);
		
		return connection;
	}

	public void insertPoint(TureBoard member) {
		TourBoardDao dao = new TourBoardDao();
		dao.insertPoint(member);
		
		
	}

	

}
