package org.glorificatio.jichitai.hp;

public class Site {


	
	private String url = null;
	
	private String title = null;
	
	private String protocol = null;
	
	private String subject = null;
	
	private boolean isChecked = false;
	
	private String tlsVersion = null;
	
	private String id = null;
	
	private String pref = null;
	
	private String city = null;
	
	public Site(String url, String id, String pref, String city) {
		super();
		this.url = url;
		this.id = id;
		this.pref = pref;
		this.city = city;
	}
	

	public String getId() {
		return id;
	}


	public String getPref() {
		return pref;
	}


	public String getCity() {
		return city;
	}


	public String getTlsVersion() {
		return tlsVersion;
	}



	public void setTlsVersion(String tlsVersion) {
		this.tlsVersion = tlsVersion;
	}

	public Site(String url) {
		super();
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public void doneCheck() { 
		this.isChecked = true;
	}

	public String getUrl() {
		return url;
	}

	public boolean isChecked() {
		return isChecked;
	}
	
	
	
}
