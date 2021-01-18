package com.hb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.hb.mapper")
@SpringBootApplication
public class ToupiaoApplication extends SpringBootServletInitializer {

  /*  public static void main(String[] args) {
        SpringApplication.run(ToupiaoApplication.class, args);
    }
*/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ToupiaoApplication.class);
    }
}
