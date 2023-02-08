package com.roles.permission.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Role_table")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rolename;
	private Boolean inActive = true;
	@CreationTimestamp
	private LocalDate date;
	@JsonIgnore
	@ManyToMany(mappedBy = "role")
	private List<User> user = new ArrayList<>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "Role_Permission", joinColumns = @JoinColumn(name = "rid"), inverseJoinColumns = @JoinColumn(name = "pid"))
	@JsonIgnore	
	private List<Permission> permission = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}

	public Role(int id, String rolename, List<User> user, List<Permission> permission) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.user = user;
		this.permission = permission;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
