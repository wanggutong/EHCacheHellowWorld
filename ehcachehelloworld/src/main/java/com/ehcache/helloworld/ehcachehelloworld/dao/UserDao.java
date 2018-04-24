package com.ehcache.helloworld.ehcachehelloworld.dao;

import com.ehcache.helloworld.ehcachehelloworld.domain.User;

public interface UserDao {

	public int insert(User user);

	public int deleteById(Integer id);

	public int update(User user);

	public User getById(Integer id);
}