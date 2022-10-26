package com.springmvcprac.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5877915975075703018L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	private String name;
	private String password;
	private String roles;
	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + name + ", password=" + password + "]";
	}
	
}
