package com.example.javaword;

import com.example.javaword.util.WordUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;

//@SpringBootApplication
public class JavaWordApplication {

    public static void main(String[] args) {

        String inputFilePath = "/Users/a123145/progrom/tmp/input.docx";
        String outputFilePath = "/Users/a123145/progrom/tmp/";
        String fileName = "output.docx";
        boolean result = false;
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("${name}","毛立欣");
        stringStringHashMap.put("${age}","56");
        try {
             result = WordUtil.addNameToTemplate(inputFilePath, stringStringHashMap, outputFilePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);
//        SpringApplication.run(JavaWordApplication.class, args);
    }

}
