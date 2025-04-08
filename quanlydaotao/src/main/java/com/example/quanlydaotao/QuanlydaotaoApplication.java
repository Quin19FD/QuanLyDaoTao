package com.example.quanlydaotao;
//
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QuanlydaotaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuanlydaotaoApplication.class, args);
	}
}
