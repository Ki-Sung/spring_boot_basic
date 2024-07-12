package com.example.TestProject.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

// Test 용 API
@RestController                     // RESTful 웹 서비스의 컨트롤러 명시
public class HelloController {      // HelloController 클래스 선언

    // HelloController 클래스의 로그 메시지를 기록하는 데 사용되는 로거 선언
    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);  // HelloController 클래스에 대한 로거 인스턴스 생성

    @RequestMapping("/hello")       // "/hello" 경로로 들어오는 HTTP GET 요청을 처리
    public String hello() {         // 해당 메서드는 "Hello World"라는 문자열을 반환
        return "Hello World";
    }

    @PostMapping("log-test")        // "/log-test" 경로로 들어오는 HTTP POST 요청을 처리
    public void logTest() {         //  로그 메시지를 기록 메서드 - 다섯 가지 로그 레벨을 사용하여 각각의 로그 메시지 출력

        LOGGER.trace("Trace Log");  // Trace 레벨
        LOGGER.debug("Debug Log");  // Debug 레벨
        LOGGER.info("Info Log");    // Info 레벨
        LOGGER.warn("Warn Log");    // Warn 레벨
        LOGGER.error("Error Log");  // Error 레벨
    }

    // POST 요청 매핑
    @PostMapping("/excption")                           // "/exception" 경로로 들어오면 HTTP POST 요청을 처리
    public void exceptionTest() throws Exception {      // 해당 메서드는 반환 값이 없으며(void), Exception을 던질 수 있음
        throw new Exception();                          // 강제로 새로운 Exception을 발생 시킴. 이로 인해 메서드가 실행되면 예외가 발생함
    }

    // 컨트롤러 예외처리
    @ExceptionHandler(value = Exception.class)          //  Exception 타입의 예외가 발생했을 때 아래 메서드가 호출되도록 함 - exceptionTest 메서드에서 예외가 발생했을 해당 메서드가 예외를 처리
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {  // 해당 메서드는 Exception 객체를 매개변수로 받아들여, ResponseEntity로 감싼 Map<String, String> 객체를 반환

        HttpHeaders responseHeaders = new HttpHeaders();    // HTTP 응답 헤더를 담는 HttpHeaders 객체를 생성

        // 응답 상태 설정
        // responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;     // HTTP 상태 코드를 BAD_REQUEST(400)로 설정

        // 로그 기록
        LOGGER.info(e.getLocalizedMessage());                   // 예외 메시지를 로그로 기록
        LOGGER.info("Controller 내 ExceptionHandler 호출");       // 예외 처리기가 호출되었음을 로그로 기록

        // 응답 메시지 생성
        Map<String, String> map = new HashMap<>();              // 문자열 키와 값을 가지는 HashMap 객체를 생성
        map.put("error type", httpStatus.getReasonPhrase());    // 맵에 "error type" 키와 HTTP 상태 코드의 설명을 값으로 추가
        map.put("code", "400");                                 //  맵에 "code" 키와 "400" 값을 추가
        map.put("message", "에러 발생");                          // 맵에 "message" 키와 "에러 발생" 값을 추가

        // 응답 반환 - 맵, 응답 헤더, HTTP 상태 코드를 포함하는 ResponseEntity 객체를 반환 -> 해당 객체는 클라이언트에게 전송
        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

}
