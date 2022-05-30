package com.zhang.controller;

import com.zhang.autoConfig.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@RestController
public class HelloController {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello springboot";
    }

    @RequestMapping("/testDataSource")
    public String testDataSource() {
        System.out.println(dataSourceProperties);

        return dataSourceProperties.toString();
    }
}
