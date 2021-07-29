package com.study.pojo;

public class ActionResult {
	private String name;
	private String next;
	private String type;
	public ActionResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActionResult(String name, String type, String next) {
		super();
		this.name = name;
		this.type = type;
		this.next = next;
	}
	public String getName() {
		return name;
	}
	public String getNext() {
		return next;
	}
	public String getType() {
		return type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ActionResult [name=" + name + ", type=" + type + ", next=" + next + "]";
	}
}
