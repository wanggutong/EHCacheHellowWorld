package com.ehcache.helloworld.ehcachehelloworld.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ehcache.helloworld.ehcachehelloworld.dao.RoleRepository;
import com.ehcache.helloworld.ehcachehelloworld.domain.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void testInsert() {
		Role role = new Role();
		role.setId(1);
		role.setName("admin");
		role.setDescr("test");
		Role result = this.roleRepository.save(role);
		System.out.println(result);
	}

	@Test
	public void testFindOne() {
		Role role = this.roleRepository.getOne(1);
		System.out.println(role);
	}

	@Test
	public void testUpdate() {
		Role role = new Role();
		role.setId(1);
		role.setName("admin");
		role.setDescr("Control authority");
		Role result = this.roleRepository.save(role);
		System.out.println(result);
	}

	@Test
	public void testDelete() {
		this.roleRepository.deleteById(Integer.valueOf(1));
	}
}