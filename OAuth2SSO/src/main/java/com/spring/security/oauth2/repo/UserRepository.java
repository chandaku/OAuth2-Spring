package com.spring.security.oauth2.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.security.oauth2.user.User;


public interface UserRepository extends JpaRepository<User, Serializable>{

	@Query("select u from User u where u.email=?1 and u.passwd=?2")
	User login(String email, String password);

	User findByEmailAndPasswd(String email, String passwd);

	User findUserByEmail(String email);

	User findByUserId(String userId);

}
