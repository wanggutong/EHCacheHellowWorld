package com.ehcache.helloworld.ehcachehelloworld.dao.impl;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ehcache.helloworld.ehcachehelloworld.dao.UserDao;
import com.ehcache.helloworld.ehcachehelloworld.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testInsert() {
		User user = new User();
		user.setId(1);
		user.setUsername("Keith Wang");
		user.setPassword("P@ssworld");
		user.setBirthday("2008-01-01");

		int result = this.userDao.insert(user);
		System.out.println(result);
	}

	@Test
	public void testGetById() {
		User user = this.userDao.getById(1);
		System.out.println(user.getUsername());
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1);
		user.setPassword("P@ssworld!");
		this.userDao.update(user);
	}

	@Test
	public void testDeleteById() {
		int result = this.userDao.deleteById(1);
		System.out.println(result);
	}
}