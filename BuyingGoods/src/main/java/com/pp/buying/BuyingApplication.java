package com.pp.buying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.pp.buying.dao")
@SpringBootApplication(scanBasePackages = "com.pp.buying")
public class BuyingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyingApplication.class, args);
    }

}
