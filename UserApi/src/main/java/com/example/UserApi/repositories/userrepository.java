package com.example.UserApi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.UserApi.entities.User;

public interface userrepository extends CrudRepository<User, Integer>{
	public User findByName(String name);

}
