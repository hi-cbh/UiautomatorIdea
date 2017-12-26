package com.uitest.testdemo;

import java.io.File;

public class Demo {


    public static void main(String[] args){
        System.out.print("hellowrld");
        File directory = new File("");
        String abPath = directory.getAbsolutePath();
//		System.out.println("user: "+System.getProperty("user.dir"));
		System.out.print("abPath"+ abPath);
//        String p = .class.getClassLoader().getResource("Demo.java").getFile();
//        System.out.print("p: " + p);
    }
}
