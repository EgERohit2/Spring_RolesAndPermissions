package com.roles.permission.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.roles.permission.entities.Permission;
import com.roles.permission.entities.Role;
import com.roles.permission.entities.User;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private User user;

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRole();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		Role role = new Role();
		List<Permission> permission = role.getPermission();

		for (Role role1 : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role1.getRolename()));
		}
		for (Permission permission1 : role.getPermission()) {
			authorities.add(new SimpleGrantedAuthority(permission1.getPersmissionname()));
		}

		return authorities;

	}

}
