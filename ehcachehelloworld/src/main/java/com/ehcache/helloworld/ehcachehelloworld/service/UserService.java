package com.ehcache.helloworld.ehcachehelloworld.service;

import com.ehcache.helloworld.ehcachehelloworld.domain.User;

public interface UserService {
	public int insert(User user);

	public int deleteById(Integer id);

	public int update(User user);

	public User getById(Integer id);
}
