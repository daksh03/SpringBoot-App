package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.User;
import com.example.repository.UserRepository;
 interface Userservice{
	User saveUser(User user);
	User getUserByUsername(String username);
}
public class UserServiceImp1 implements Userservice {
@Autowired
private UserRepository userRepository;
@Override
public User saveUser(User user) {
	return userRepository.save(user);
}
@Override
public User getUserByUsername(String username) {
	return userRepository.findByUsername(username);
}
}
