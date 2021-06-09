package com.alkemy.DisneyAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @RequestMapping("/test")
    @ResponseBody
    public String hello() {
        int x = 2121;
        return "asdasd" + x;
    }

}
