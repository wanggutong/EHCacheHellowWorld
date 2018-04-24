package com.ehcache.helloworld.ehcachehelloworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ehcache.helloworld.ehcachehelloworld.dao.UserDao;
import com.ehcache.helloworld.ehcachehelloworld.domain.User;
import com.ehcache.helloworld.ehcachehelloworld.service.UserService;

@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@CachePut(key = "#user.id")
	public int insert(User user) {
		System.out.println(String.format("Call User Dao to Create a New User %s.", user.getId()));
		return userDao.insert(user);
	}

	@Override
	@CacheEvict(key = "#id")
	public int deleteById(Integer id) {
		System.out.println(String.format("Call User Dao to Remove a New User %s.", id));
		return userDao.deleteById(id);
	}

	@Override
	@CachePut(key = "#user.id")
	public int update(User user) {
		System.out.println(String.format("Call User Dao to Update a New User %s.", user.getId()));
		return userDao.update(user);
	}

	@Override
	@Cacheable(key = "#id")
	public User getById(Integer id) {
		System.out.println(String.format("Call User Dao to Find a New User %s.", id));
		return userDao.getById(id);
	}
}
