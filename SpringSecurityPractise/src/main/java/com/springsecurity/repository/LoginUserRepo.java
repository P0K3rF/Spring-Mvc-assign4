package com.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springsecurity.entity.LoginUser;

public interface LoginUserRepo extends CrudRepository<LoginUser, Integer>{
	Optional<LoginUser> findByUserName(String userName);
}
