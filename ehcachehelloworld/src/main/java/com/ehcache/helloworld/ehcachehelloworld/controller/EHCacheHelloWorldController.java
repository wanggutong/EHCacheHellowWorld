package com.ehcache.helloworld.ehcachehelloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ehcache")
public class EHCacheHelloWorldController {
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String helloworld() {
		System.out.println("Hello World");
		return "helloworld";
	}

	@RequestMapping(value = "/helloworld2", method = RequestMethod.GET)
	public String helloworld2() {
		return "helloworld2";
	}
}
