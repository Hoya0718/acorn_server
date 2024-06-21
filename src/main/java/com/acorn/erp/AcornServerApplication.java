package com.acorn.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.acorn.erp.domain.Exam.Repository")
public class AcornServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcornServerApplication.class, args);
    }
}