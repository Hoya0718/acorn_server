package com.acorn.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.acorn.erp.domain.Reservation")
@ComponentScan(basePackages = {"com.acorn.erp.domain.Stock"})
public class AcornServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcornServerApplication.class, args);
    }
}