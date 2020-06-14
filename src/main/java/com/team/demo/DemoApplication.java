package com.team.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.team.demo.mapper") //扫描mapper
//使用ComponentScan注解指定扫描某包下的spring注解
@ComponentScan(value = "com.team")
//扫描filter
@ServletComponentScan(value = "com.team.demo.filter")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
