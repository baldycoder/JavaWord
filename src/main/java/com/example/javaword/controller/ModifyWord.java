package com.example.javaword.controller;

import com.example.javaword.service.ModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：a123145
 * @date ：Created in 2022/7/26 16:18
 * @description：修改word请求
 * @modified By：`
 * @version: 1.0
 */

@RestController
@Slf4j
public class ModifyWord {

    @Autowired
    ModifyService modifyService;

    @RequestMapping("/test")
    public String modifyTemplate(){

        return "success";
    }

}
