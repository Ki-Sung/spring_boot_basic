package com.example.TestProject.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// 글로벌 예외처리
@RestControllerAdvice                               // 해당 클래스가 모든 컨트롤러에서 발생하는 예외를 처리하는 역할을 한다는 것을 나타냄
public class TestProjectExceptionHandler {          // 클래스 선언 - 글로벌 예외처리

    // 로거 선언
    // 로깅을 위한 Logger 객체를 생성
    private final Logger LOGGER = LoggerFactory.getLogger(TestProjectExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)                  //  Exception 타입의 예외가 발생했을 때 아래 메서드가 호출되도록 함
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {  // Exception 객체를 매개변수로 받아들여, ResponseEntity로 감싼 Map<String, String> 객체를 반환

        // HTTP 헤더 생성
        HttpHeaders responseHeaders = new HttpHeaders();        //  HTTP 응답 헤더를 담는 HttpHeaders 객체를 생성

        // 응답 상태 설정
        // responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;         // HTTP 상태 코드를 BAD_REQUEST(400)로 설정

        // 로그 기록
        LOGGER.info("Advice 내 ExceptionHandler 호출");           // 예외 처리가 호출되었음을 로그에 기록

        // 응답 메시지 생성
        Map<String, String> map = new HashMap<>();              // 문자열 키와 값을 가지는 HashMap 객체를 생성
        map.put("error type", httpStatus.getReasonPhrase());    // 맵에 "error type" 키와 HTTP 상태 코드의 설명을 값으로 추가
        map.put("code", "400");                                 //  맵에 "code" 키와 "400" 값을 추가
        map.put("message", "에러 발생");                          // 맵에 "message" 키와 "에러 발생" 값을 추가

        // 응답 반환 - 맵, 응답 헤더, HTTP 상태 코드를 포함하는 ResponseEntity 객체를 반환 -> 해당 객체는 클라이언트에게 전송
        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    // 모든 컨트롤러에서 발생하는 예외를 처리를 담당
    @ExceptionHandler(value = TestProjectException.class)       // TestProjectException 타입의 예외가 발생했을 때 이 메서드가 호출되도록 함
    public ResponseEntity<Map<String, String>> ExceptionHandler(TestProjectException e) {   // TestProjectException 객체를 매개변수로 받아들여, ResponseEntity로 감싼 Map<String, String> 객체를 반환
        HttpHeaders responseHeaders = new HttpHeaders();        // HttpHeaders 객체를 생성하여 HTTP 응답 헤더를 담기

        Map<String, String> map = new HashMap<>();                      // map 객체를 생성하여 응답 메시지 담기
        map.put("error type", e.getHttpStatusType());                   // "error type" 키와 예외의 HTTP 상태 타입 추가
        map.put("error code", Integer.toString(e.getHttpStatusCode())); // "error code" 키와 예외의 HTTP 상태 코드 추가
        map.put("message", e.getMessage());                             //  "message" 키와 예외 메시지 추가

        // map, responseHeaders, e.getHttpStatus()를 포함하는 ResponseEntity 객체 반환
        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }

}
