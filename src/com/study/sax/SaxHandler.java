package com.study.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.study.pojo.Student;
//助手类,定义读取到相关部分的回调函数,类似于swing中的事件监听程序
public class SaxHandler extends DefaultHandler{
	private List<Student> data;
	private Student stu;
	private String eleName;
	public List<Student> getData() {
		return data;
	}
	public void startDocument() throws SAXException {
		data=new ArrayList<>();
	}
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("stu".equals(qName)){//读到stu的开始标记
			stu=new Student();//创建新对象
			String no=attributes.getValue("id");//取id属性
			stu.setNo(no);
		}
		eleName=qName;//记住当前的标签名称
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		String val=new String(ch,start,length);//获得文本
		if("name".equals(eleName)){//判断当前的标签是哪一个
			stu.setName(val);//调用对应的setXxx方法
		}else if("weapon".equals(eleName)){
			stu.setWeapon(val);
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		eleName="";//清空
		if("stu".equals(qName)){//读到stu的结束标记
			data.add(stu);//加入集合
		}
	}
	public void endDocument() throws SAXException {
		//System.out.println("endDocument");
	}
}
