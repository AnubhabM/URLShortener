package com.bootCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.bootCrud.models.UrlRequest;
import com.bootCrud.models.UrlResponse;
import com.bootCrud.services.UrlService;
@RestController
@CrossOrigin(value="*")
public class CrudController {
	
	@Autowired
	private UrlService urlService;
	@Autowired
	private UrlResponse urlResponse;
	
	@RequestMapping(value="/{smallUrl}", method=RequestMethod.GET)
	public RedirectView hello(@PathVariable String smallUrl){
		System.out.println("url"+smallUrl);
		String bigUrl=urlService.getBigUrl(smallUrl);
		
		System.out.println(bigUrl);
		
		if(bigUrl!=null && !bigUrl.equalsIgnoreCase("Error")) {
			String start=bigUrl.substring(0,3);
			System.out.println(start);
			if(start.equals("htt")||start.equals("ftp")||start.equals("smt")) {
				System.out.println(bigUrl);				
				return new RedirectView(bigUrl);
			}
			else
				System.out.println("here");
			return new RedirectView("http://"+bigUrl);
		}
		else
		return new RedirectView("http://localhost:4200");
		
		
	}
	
	
	
	@RequestMapping(value="/getUrl",  method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public UrlResponse getUrl(@RequestBody UrlRequest urlRequest) {
		
		System.out.println("bigUrl :"+urlRequest.getBigUrl());
		
		String smallUrl=urlService.makeSmallUrl(urlRequest.getBigUrl());
		
		urlResponse.setSmallUrl(smallUrl);
		
		return urlResponse;

		
		
		
	}
	
	
	
}
