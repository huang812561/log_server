package com.ykc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ykc.mapper")
@SpringBootApplication
public class LogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogServerApplication.class, args);
	}

}
