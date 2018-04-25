package com.ehcache.helloworld.ehcachehelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehcache.helloworld.ehcachehelloworld.domain.User;

@Controller
@RequestMapping("fastjson")
public class FastJsonController {

	@RequestMapping("/test")
	@ResponseBody
	public User test() {
		User user = new User();

		user.setId(1);
		user.setUsername("jack");
		user.setPassword("jack123");
		user.setBirthday("2000-01-01");

		return user;
	}
}