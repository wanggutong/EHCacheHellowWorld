package com.ehcache.helloworld.ehcachehelloworld.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController {
	@RequestMapping(method = RequestMethod.GET)
    public String hello(Map<String,Object> map) {
        
        map.put("msg", "HomePage");
        return "hello";
    }
}
