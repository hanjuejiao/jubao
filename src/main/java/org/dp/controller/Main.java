package org.dp.controller;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by hanju on 2017/6/9.
 */
public class Main {
    public static void main(String[] args){
        try {
         //   FileInputStream fis = new FileInputStream("D:/a/a.txt");
        	String path = "D:/static/report";
        	File file = new File(path);
        	if(!file.exists()){
        		file.mkdirs();
        	}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
