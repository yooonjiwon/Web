package com.seoul.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.seoul.dao.GuideBoardDao;
import com.seoul.dto.Guide;
import com.seoul.dto.GuideBoardAttach;
import com.seoul.dto.GuideBoardComment;
import com.seoul.guideservlet.GuideFileUploadServlet;


public class GuideBoardService {

	public int writeBoard(Guide guide) {
		GuideBoardDao dao = new GuideBoardDao();
		int newBoardNo = dao.insertBoard(guide);
		/**/	return newBoardNo;
	}

	public List<Guide> findBoardList() {
		GuideBoardDao dao = new GuideBoardDao();
		List<Guide> guides = dao.selectBoardList();
		return guides;
	}

	
	
	
	public List<Guide> findBoardList(int first, int last) {
		GuideBoardDao dao = new GuideBoardDao();
		List<Guide> guides = dao.selectBoardList2(first, last);
		return guides;
	}

	


		
	
	public int getGuideBoardCount() {
		GuideBoardDao dao = new GuideBoardDao();
		int count = dao.getBoardCount();
		return count;
	}

	public Guide findBoardByBoardNo(int gub_BoardNo) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		Guide guide = guideBoardDao.selectBoardByBoardNo(gub_BoardNo);

		
/*		ArrayList<GuideBoardAttach> sub_Attachments = GuideBoardDao.selectBoardAttachByBoardNo(gub_BoardNo);
		guide.setSub_Attachments(sub_Attachments);*/
		ArrayList<GuideBoardComment> gub_Comments = guideBoardDao.selectCommentByBoardNo(gub_BoardNo);
		guide.setGub_Comments(gub_Comments);
		return guide;
	}
		
		
/*		ArrayList<GuideBoardComment> guideComments = guideBoardDao.selectCommentByBoardNo(gub_BoardNo);
		guide.setGub_Comments(guideComments);
		return guide;
	}*/

	public void increaseReadCount(int gub_BoardNo) {
		GuideBoardDao boardDao = new GuideBoardDao();
		boardDao.updateReadCount(gub_BoardNo);
		
	}

	public void deleteBoard(int gub_BoardNo) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		guideBoardDao.deleteBoard(gub_BoardNo);
	}

	public void updateBoard(Guide guide) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		guideBoardDao.updateBoard(guide);
	}


	public void writeComment(GuideBoardComment guideBoardComment) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		guideBoardDao.insertComment(guideBoardComment);
	}

	public void updateComment(GuideBoardComment guideComment) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		guideBoardDao.updateComment(guideComment);
	}

	public void deleteComment(int guc_CommentNo) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		guideBoardDao.deleteComment(guc_CommentNo);
	}

	public GuideBoardAttach findBoardAttachByAttachNo(int sub_AttachNo) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		GuideBoardAttach guideAttachment = guideBoardDao.selectBoardAttachByAttachNo(sub_AttachNo);
		return guideAttachment;
	}

	public void saveBoardAttach(GuideBoardAttach guideAttachment) {
		GuideBoardDao guideBoardDao = new GuideBoardDao();
		guideBoardDao.insertBoardAttach(guideAttachment);
		
	}

	public int GuideFileUpload(GuideFileUploadServlet guide) {
		GuideBoardDao dao = new GuideBoardDao();
		int newBoardNo = dao.fileUploadBoard(guide);
		return newBoardNo;
	}

	








	
	

}
