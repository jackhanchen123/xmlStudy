package com.study.dom;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.study.pojo.Student;

public class DomParser {
	public static void main(String[] args) {
		List<Student> list=new DomParser().parseXml();
		for(Student stu:list){
			System.out.println(stu);
		}
	}
	//通过DOM解析xml文件,将解析的结果保存在List中
	public List<Student> parseXml(){
		List<Student> list=new ArrayList<>();
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//获得解析器工厂
			DocumentBuilder builder=factory.newDocumentBuilder();//获得解析器
			InputStream is=DomParser.class.getClassLoader().getResourceAsStream("data.xml");
			Document document=builder.parse(is); //加载xml文件,获得代表这个xml文件的Document对象
			NodeList nodeList=document.getElementsByTagName("stu");//获得所有stu节点
			for(int i=0;i<nodeList.getLength();i++){//遍历集合
				Element stuEle=(Element)nodeList.item(i);//取出当前元素
				String no=stuEle.getAttribute("id");//取出id属性
				Element nameEle=(Element)stuEle.getElementsByTagName("name").item(0);//<name>孙悟空</name>
				String name=nameEle.getFirstChild().getNodeValue();//孙悟空
				Element weaponEle=(Element)stuEle.getElementsByTagName("weapon").item(0);//<weapon>金箍棒</weapon>
				String weapon=weaponEle.getFirstChild().getNodeValue();//金箍棒
				Student stu=new Student(no,name,weapon);//组装数据到对象中
				list.add(stu);//添加到集合里
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
