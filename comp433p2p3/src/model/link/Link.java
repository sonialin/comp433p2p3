package model.link;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Link")
public class Link {
	private String method;
	private String mediatype;
	private String action;
	private String url;

	public Link() {
	}


	
	public Link(String method, String mediatype,String action, String url) {
		this.method = method;
		this.action = action;
		this.url = url;
		this.mediatype = mediatype;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMediatype() {
		return mediatype;
	}

	public void setMediatype(String mediatype) {
		this.mediatype = mediatype;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

