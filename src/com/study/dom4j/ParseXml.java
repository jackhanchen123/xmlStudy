package com.study.dom4j;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

import com.study.pojo.Student;

public class ParseXml {
	
	public Map<String,Student> parseBySax(){
		Map<String,Student> map=new HashMap<>();
		try {
			InputStream is=ParseXml.class.getClassLoader().getResourceAsStream("data.xml");
			SAXReader saxReader=new SAXReader();//采用SAX方式进行解析,获得SAX解析器
			org.dom4j.Document doc=saxReader.read(is);
			//DOM4j封装了dom和sax,提供了统一的API实现对xml的操作
			Element rootEle=doc.getRootElement();//获得根节点
			Iterator<Element> it=rootEle.elementIterator();//获得迭代器
			while(it.hasNext()){//使用迭代器进行迭代
				Student stu=new Student();
				Element ele=it.next();
				stu.setNo(ele.attributeValue("id"));
				stu.setName(ele.element("name").getText());
				stu.setWeapon(ele.elementText("weapon"));
				map.put(stu.getNo(), stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String,Student> parseByDom(){
		Map<String,Student> map=new HashMap<>();
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//获得解析器工厂
			DocumentBuilder builder=factory.newDocumentBuilder();//获得解析器
			InputStream is=ParseXml.class.getClassLoader().getResourceAsStream("data.xml");
			org.w3c.dom.Document document=builder.parse(is); //加载xml文件,获得代表这个xml文件的Document对象

			DOMReader domReader=new DOMReader();//采用DOM方式进行解析,获得DOM解析器
			org.dom4j.Document doc=domReader.read(document);//将w3c下的Document转成dom4j的Document
			Element rootEle=doc.getRootElement();//获得根节点
			Iterator<Element> it=rootEle.elementIterator();//获得迭代器
			while(it.hasNext()){//使用迭代器进行迭代
				Student stu=new Student();
				Element ele=it.next();
				stu.setNo(ele.attributeValue("id"));
				stu.setName(ele.element("name").getText());
				stu.setWeapon(ele.elementText("weapon"));
				map.put(stu.getNo(), stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static void main(String[] args) {
		Map<String,Student> map=new ParseXml().parseBySax();
		Set<Map.Entry<String,Student>> entrySet=map.entrySet();
		Iterator<Map.Entry<String,Student>> it=entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String,Student> entry=it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
