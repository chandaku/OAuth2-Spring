package com.xebia.oauth2.config.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.oauth2.config.user.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
