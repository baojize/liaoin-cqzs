package com.liaoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liaoin.mapper")
public class LiaoinCqzApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiaoinCqzApplication.class, args);
	}
}


