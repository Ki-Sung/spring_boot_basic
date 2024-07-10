package com.example.TestProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // @RequestMapping(value = "/hello", method = RequestMethod.GET) -> 이전 방식
    @GetMapping("hello")          // 최근 방식
    // 메소드 만들기
    public String hello() {
        return "Hello World";
    }
}
