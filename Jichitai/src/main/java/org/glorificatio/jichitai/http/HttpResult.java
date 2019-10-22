package org.glorificatio.jichitai.http;

public class HttpResult {

	public HttpResult() {
	}
	
	
	private int statusCode = 0;
	
	private String title = null;
	
	private String subject = null;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
