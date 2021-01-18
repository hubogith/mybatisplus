package com.hb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hb.mapper")
@SpringBootApplication
public class MybatisplustestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplustestApplication.class, args);
    }

}
