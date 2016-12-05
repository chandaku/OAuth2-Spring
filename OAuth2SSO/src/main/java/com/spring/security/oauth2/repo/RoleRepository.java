package com.spring.security.oauth2.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.oauth2.user.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
