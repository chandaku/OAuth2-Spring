/**
 * 
 */
package com.xebia.oauth2.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser extends User implements UserDetails
{
	
	private static final long serialVersionUID = 1L;
	public SecurityUser(User user) {
		if(user != null)
		{
			this.setId(user.getId());
			this.setUserId(user.getUserId());
			this.setEmail(user.getEmail());
			this.setPasswd(user.getPasswd());
			this.setRoles(user.getRoles());
			this.setActive(user.getActive());
		}		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> userRoles = this.getRoles();
		
		if(userRoles != null)
		{
			for (Role role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPasswd();
	}

	@Override
	public String getUsername() {
		return super.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return /*super.getActive()==null || "Y".equals(super.getActive())*/true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return /*super.getActive()!=null && super.getActive().equals("Y")*/true;
	}
	
}

