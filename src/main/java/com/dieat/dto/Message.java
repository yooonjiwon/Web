package com.dieat.dto;

import java.util.Date;

/**
 * Member 테이블의 데이터와 매핑되는 DTO 클래스 <br>
 * 사용자 정보를 관리하는 역할
 * @author Administrator
 *
 */
public class Message {

	private int msgNo;
	private String msgSendId;
	private String msgRecevId;
	private String msgTitle;
	private String msgContent;
	private String msgConfirm;
	private Date msgDate;
	
	
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public String getMsgSendId() {
		return msgSendId;
	}
	public void setMsgSendId(String msgSendId) {
		this.msgSendId = msgSendId;
	}
	public String getMsgRecevId() {
		return msgRecevId;
	}
	public void setMsgRecevId(String msgRecevId) {
		this.msgRecevId = msgRecevId;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getMsgConfirm() {
		return msgConfirm;
	}
	public void setMsgConfirm(String msgConfirm) {
		this.msgConfirm = msgConfirm;
	}
	public Date getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	
}









