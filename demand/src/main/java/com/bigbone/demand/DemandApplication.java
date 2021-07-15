package com.bigbone.demand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bigbone.demand.dao")
public class DemandApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemandApplication.class, args);
    }

}
