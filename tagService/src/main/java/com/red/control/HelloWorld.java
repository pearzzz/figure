package com.red.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 9:35 2022-07-26
 */
@RestController
public class HelloWorld {

    @RequestMapping("hello")
    public String helloworld(String name) {
        return name;
    }
}
