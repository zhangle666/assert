package com.virtue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.virtue.mapper")
@SpringBootApplication
public class SpringbootAssetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAssetsApplication.class, args);
    }

}
