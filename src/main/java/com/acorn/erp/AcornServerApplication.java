package com.acorn.erp;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.acorn.erp.domain.Stock"})

public class AcornServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcornServerApplication.class, args);
    }
}