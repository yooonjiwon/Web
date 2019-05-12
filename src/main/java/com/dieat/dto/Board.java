package com.dieat.dto;

import java.util.ArrayList;
import java.util.Date;

public class Board {
	
	private int boardNo;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private int readCount;
	private boolean deleted;
	private int category;
	private int recommend;
	
	//Board와 BoardAttach 테이블의 1:Many 관계를 구현하는 변수
	ArrayList<BoardAttach> attachments;
	
	
	
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public ArrayList<BoardAttach> getAttachments() {
		return attachments;
	}
	public void setAttachments(ArrayList<BoardAttach> attachments) {
		this.attachments = attachments;
	}
	
	

}
