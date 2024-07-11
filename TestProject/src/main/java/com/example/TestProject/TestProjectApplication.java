package com.example.TestProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  								// Spring Boot 애플리케이션을 설정하고 실행 - 여러 어노테이션을 한꺼번에 사용하는 복합 어노테이션
public class TestProjectApplication {					// 클래스 정의 - public 키워드는 이 클래스가 다른 클래스에도 접근 가능함을 의미

	// 시작점 - 모든 자바 애플리케이션은 main 메서드를 가지고 있어야 함. (String[] args)는 명령줄 인수를 받을 수 있도록 함
	public static void main(String[] args) {

		// Spring Boot 애플리케이션을 실행하는 명령 - 현재 클래스(TestProjectApplication)를 애플리케이션의 시작 클래스로 지정, args는 명령줄 인수를 전달함
		SpringApplication.run(TestProjectApplication.class, args);
	}

}
