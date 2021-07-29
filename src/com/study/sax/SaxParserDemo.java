package com.study.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.study.pojo.Student;


public class SaxParserDemo {
	public static void main(String[] args) {
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance();//获得解析器工厂
			SAXParser builder=factory.newSAXParser();//获得解析器
			InputStream is=SaxParserDemo.class.getClassLoader().getResourceAsStream("data.xml");
			SaxHandler handler=new SaxHandler();//实例化一个助手类
			builder.parse(is,handler);
			List<Student> list=handler.getData();//获得解析结果
			for(Student stu:list){
				System.out.println(stu);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
