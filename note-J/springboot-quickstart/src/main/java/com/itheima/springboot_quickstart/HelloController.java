package com.itheima.springboot_quickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 标识为请求处理类
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }
}
