package springbook.user.domain;

import lombok.Data;
import lombok.Getter;

@Getter
public class User {
	String id;
	String name;
	String passwordString;
	
	public User setId(String id) {
		this.id = id ;
		return this;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public User setPasswordString(String passwordString) {
		this.passwordString = passwordString;
		return this;
	}
	
	
}
