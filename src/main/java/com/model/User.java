package com.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {
    
	@NotEmpty(message="姓名不能为空")
	private String userName;
	
	@NotEmpty(message="密码不能为空")
	@Length(min=6,message="密码长度不能小于6位")
	private String password;
	
	@Max(value = 100,message = "年龄不能大于100岁")
	@Min(value = 18,message = "必须年满18岁!")
	private int age;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
