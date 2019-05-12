package com.dieat.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 * 운동방법 게시판 Dto
 * @author Jiwon
 */

public class Workout {
	
	private int boardNo;
	private String title;
	private String type;
	private String type2;
	private String content;
	private int like;
	private String url;
	private Date regDate;
	private int readCount;
	private boolean deleted;
	private int groupNo;
	private int depth;
	private int step;

//	//Board와 BoardComment 테이블의 1:Many 관계를 구현하는 변수
//	ArrayList<WorkoutBoardComment> comments;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
//	public ArrayList<WorkoutBoardComment> getComments() {
//		return comments;
//	}
//	public void setComments(ArrayList<WorkoutBoardComment> comments) {
//		this.comments = comments;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
}



