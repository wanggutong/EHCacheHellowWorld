package com.ehcache.helloworld.ehcachehelloworld.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehcache.helloworld.ehcachehelloworld.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}	