package com.study.pojo;

public class Student {
	private String name;
	private String no;
	private String weapon;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String no, String name, String weapon) {
		super();
		this.no = no;
		this.name = name;
		this.weapon = weapon;
	}
	public String getName() {
		return name;
	}
	public String getNo() {
		return no;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", weapon=" + weapon + "]";
	}
}
