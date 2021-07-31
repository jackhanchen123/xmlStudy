package com.study.my;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * jsonp 解析xml入门
 */
public class JsoupXmlStudy {
    public static void main(String[] args) throws IOException {
        String path = JsoupXmlStudy.class.getClassLoader().getResource("data.xml").getPath();
        System.out.println(path);
        Document document = Jsoup.parse(new File(path), "utf-8");


    }

    //1.获取document对象，通过xml文档获取

    //2.获取对应标签
    //3.获取数据




}
