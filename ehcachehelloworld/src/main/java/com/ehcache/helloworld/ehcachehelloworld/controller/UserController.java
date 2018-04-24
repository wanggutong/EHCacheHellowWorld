package com.ehcache.helloworld.ehcachehelloworld.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehcache.helloworld.ehcachehelloworld.domain.User;
import com.ehcache.helloworld.ehcachehelloworld.service.UserService;

@Controller
@RequestMapping("user")
@ResponseBody
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> save(User user) {
		int status = this.userService.insert(user);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "Saved Successfully");
		if (status == 1) {
			map.put("data", user);
		}
		return map;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> get(@RequestParam("id") Integer id) {
		User user = this.userService.getById(id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "Got Successfully");
		map.put("data", user);
		return map;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> update(User user) {
		int status = this.userService.update(user);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "Updated Successfully");
		if (status == 1) {
			map.put("data", user);
		}
		return map;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public Map<String, Object> delete(@RequestParam("id") Integer id) {
		this.userService.deleteById(id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "Deleted Successfully");
		return map;
	}
}
