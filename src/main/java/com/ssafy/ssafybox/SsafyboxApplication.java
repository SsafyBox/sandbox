package com.ssafy.ssafybox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsafyboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsafyboxApplication.class, args);

		System.out.println("정상적으로 서버가 실행되었습니다.");

	}
}