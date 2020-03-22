package com.pro.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 
 * @author wgl
 * @Date 2020-2-15
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.pro.study.dao.*")
public class ProApi{

  

	public static void main(String[] args) {
		SpringApplication.run(ProApi.class, args);
	}
	
	
}
