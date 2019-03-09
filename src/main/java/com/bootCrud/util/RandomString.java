package com.bootCrud.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomString {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	static SecureRandom rnd = new SecureRandom();

	public String randomString( int len ){
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
}
