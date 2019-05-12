package com.seoul.controller;

/**
 * Action Controller가 반환하는 데이터 클래스<br>
 * view를 선택하는 데 필요한 정보 전달
 * @author jiwon
 *
 */

public class ActionResult {

	private String url;
	private boolean redirect;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
