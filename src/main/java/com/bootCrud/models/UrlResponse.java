package com.bootCrud.models;

import org.springframework.stereotype.Component;

@Component
public class UrlResponse {
	private String smallUrl;

	public String getSmallUrl() {
		return smallUrl;
	}

	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}
	
}
