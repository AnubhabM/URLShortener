package com.bootCrud.util;

import org.springframework.stereotype.Component;

@Component
public class SmallUrlMaker {
	public String urlMaker(String SmallUrl) {
		if(SmallUrl!=null) {
			String baseUrl="http://localhost:9000/";

			return baseUrl+SmallUrl;
		}
		else {
			return "Error Occurred";
		}

	}
}
