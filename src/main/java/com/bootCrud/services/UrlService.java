package com.bootCrud.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootCrud.models.Url;
import com.bootCrud.repositories.UrlRepository;
import com.bootCrud.util.RandomString;
import com.bootCrud.util.SmallUrlMaker;

@Service
public class UrlService {
	@Autowired
	private RandomString randomStr;
	@Autowired
	private UrlRepository urlRepo;
	@Autowired
	private SmallUrlMaker getUrl;

	public String makeSmallUrl(String bigUrl) {

		String smallUrl=null;


		if(bigUrl!=null) {

			Url urlCheck=new Url();
			urlCheck=urlRepo.findBybigUrl(bigUrl);

			if(urlCheck!=null && urlCheck.getBigUrl()!= null && urlCheck.getBigUrl().equalsIgnoreCase(bigUrl)) {
				System.out.println("URL already exists");
				return "Url Already Shortened::  "+getUrl.urlMaker(urlCheck.getSmallUrl());
			}
			else {
				smallUrl=randomStr.randomString(10);
				System.out.println("Small Url from service: "+smallUrl);
				Url url=new Url();
				url.setBigUrl(bigUrl);
				url.setSmallUrl(smallUrl);
				url.setCreatedAt(new Date());
				url.setUpdatedAt(new Date());
				if(urlRepo.save(url) != null) {
					System.out.println("data pushed:: total ::"+urlRepo.count());
				}
				return getUrl.urlMaker(smallUrl);
			}
		}

		return null;

	}

	public String getBigUrl(String smallUrl) {

		if(smallUrl!=null) {

			Url url=new Url();
			url=urlRepo.findBysmallUrl(smallUrl);

			return url.getBigUrl();

		}
		else {
			return "Error";
		}

	}
}
