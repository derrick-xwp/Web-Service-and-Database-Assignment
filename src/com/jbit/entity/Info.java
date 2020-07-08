package com.jbit.entity;

import java.io.Serializable;
import java.util.List;

public class Info implements Serializable {

	private int userId;
	private String sex;
	private int age;
	private Person person;
	private String borthday;
	private double hight;
	
	@Override
	public String toString() {
		return "Info [userId=" + userId + ", sex=" + sex + ", age=" + age + ", person=" + person + ", borthday="
				+ borthday + ", hight=" + hight + "]";
	}
	public String getBorthday() {
		return borthday;
	}
	public void setBorthday(String borthday) {
		this.borthday = borthday;
	}
	public double getHight() {
		return hight;
	}
	public void setHight(double hight) {
		this.hight = hight;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
