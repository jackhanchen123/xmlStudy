package com.study.pojo;

import java.util.Map;

public class ActionMapping {
	private String className;
	private String name;
	private Map<String,ActionResult> resultMap;
	public ActionMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActionMapping(String name, String className, Map<String, ActionResult> resultMap) {
		super();
		this.name = name;
		this.className = className;
		this.resultMap = resultMap;
	}
	public String getClassName() {
		return className;
	}
	public String getName() {
		return name;
	}
	public Map<String, ActionResult> getResultMap() {
		return resultMap;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setResultMap(Map<String, ActionResult> resultMap) {
		this.resultMap = resultMap;
	}
	@Override
	public String toString() {
		return "ActionMapping [name=" + name + ", className=" + className + ", resultMap=" + resultMap + "]";
	}
}
