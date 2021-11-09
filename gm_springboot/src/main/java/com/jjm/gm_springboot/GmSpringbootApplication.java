package com.jjm.gm_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.jjm.gm_springboot.mapper")
public class GmSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmSpringbootApplication.class, args);
    }

}
