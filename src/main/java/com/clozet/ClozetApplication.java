package com.clozet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@SpringBootApplication()
//aduting
//@EnableJpaAuditing    공통 어노테이션 등록
public class ClozetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClozetApplication.class, args);
    }

}
