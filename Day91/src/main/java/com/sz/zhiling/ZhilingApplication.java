package com.sz.zhiling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ZhilingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZhilingApplication.class, args);
    }

}
