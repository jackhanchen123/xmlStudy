package com.study.myjsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * jsonp 解析xml  jsoup快速入门
 *
 *
 */
public class JsoupXmlStudy {
    public static void main(String[] args) throws IOException {
        //获取路径path
        String path = JsoupXmlStudy.class.getClassLoader().getResource("data.xml").getPath();
        System.out.println(path);

        //1.获取document对象，通过xml文档获取 --》Jsoup.parse
        Document document = Jsoup.parse(new File(path), "utf-8");//字符集与文件字符集一致
        System.out.println(document);
        //2.获取对应标签
        Elements elementsByTag = document.getElementsByTag("name");
        Element element = elementsByTag.get(0);
        System.out.println("--------打印第一个name---------------------");
        System.out.println(element);
        //3.获取数据
        String text = element.text();
        System.out.println("--------name标签里的文本---------------------");
        System.out.println(text);
    }









}
