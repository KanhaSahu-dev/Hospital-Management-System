package com.org;

public class Student {
private int id;
private String name;
private int age;
private String email;
private String password;
private String gender;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Student(int id, String name, int age, String email, String password, String gender) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.email = email;
	this.password = password;
	this.gender = gender;
}

public Student() {
	super();
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", password=" + password
			+ ", gender=" + gender + "]";
}
}
