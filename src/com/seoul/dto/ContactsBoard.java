package com.seoul.dto;

import java.util.ArrayList;
import java.util.Date;

public class ContactsBoard {

	private int boardNo;
	private String title;
	private String writer;
	private int boardType;
	private String content;
	private Date regDate;
	private int readCount;
	private boolean deleted;
	private String password;
	
	private int groupNo;
	private int step;
	private int depth;
	
	ArrayList<ContactsAttach> attachments;
	ArrayList<ContactsComment> comments;
	
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public void setisDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public ArrayList<ContactsAttach> getAttachments() {
		return attachments;
	}
	public void setAttachments(ArrayList<ContactsAttach> attachments) {
		this.attachments = attachments;
	}
	public ArrayList<ContactsComment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<ContactsComment> comments) {
		this.comments = comments;
	}
	public int getBoardType() {
		return boardType;
	}
	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
