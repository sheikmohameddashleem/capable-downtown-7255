package com.bms;

import java.io.Serializable;
import java.util.Objects;

public class Faculty implements Serializable {

	public int FacultyId;
	public String name;
	public String username;
	private String password;
	
	Faculty(){
		super();
	}
	Faculty(int fac,String name,String usname,String password){
		this.FacultyId=fac;
		this.name=name;
		this.username=usname;
		this.password=password;
	}
	public int getFacultyId() {
		return FacultyId;
	}
	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(FacultyId, name, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return FacultyId == other.FacultyId && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Faculty [FacultyId=" + FacultyId + ", name=" + name + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
}
