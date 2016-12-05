/**
 * 
 */
package com.spring.security.oauth2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.security.oauth2.repo.UserRepository;
import com.spring.security.oauth2.user.User;



@Service
@Transactional
public class UserService 
{
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User findUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	public User login(String email, String passwd) {
		return userRepository.findByEmailAndPasswd(email,passwd);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	
}

