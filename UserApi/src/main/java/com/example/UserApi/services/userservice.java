package com.example.UserApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserApi.entities.User;
import com.example.UserApi.exceptions.UserNotFoundException;
import com.example.UserApi.repositories.userrepository;



@Service
public class userservice {
	
	@Autowired
	 private userrepository userRepository;
	
	

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public User GetUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        return foundUser;
    }
    
    public User GetUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }


}