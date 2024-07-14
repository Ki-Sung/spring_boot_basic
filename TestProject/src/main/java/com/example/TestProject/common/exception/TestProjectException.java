package com.example.TestProject.common.exception;

import com.example.TestProject.common.Constants;
import org.springframework.http.HttpStatus;

// 사용자 정의 예외 클래스 정의

public class TestProjectException extends Exception{        // TestProjectException이라는 새로운 클래스를 정의 - Exception 클래스를 확장(상속) 함
    private static final long serialVersionUID = 4663380430591151694L;  // serialVersionUID는 직렬화(Serialization)와 관련된 고유 식별자 - 주로 객체를 파일로 저장하거나 네트워크로 전송할 때 사용

    private Constants.ExceptionClass exceptionClass;        // 인스턴스 변수 선언 - exceptionClass
    private HttpStatus httpStatus;                          // 인스턴스 변수 선언 - httpStatus

    // 예외 처리 - 예외가 발생했을 때 호출 -  exceptionClass, httpStatus, message를 매개변수로 받아서 Exception 클래스의 생성자를 호출하고, 인스턴스 변수들을 초기화
    public TestProjectException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    // 예외 발생시 - exceptionClass 값을 반환
    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    // httpStatus의 상태 코드를 정수(int)로 반환
    public int getHttpStatusCode() {
        return httpStatus.value();
    }


    // httpStatus의 상태 타입을 문자열(String)로 반환
    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    // httpStatus 객체를 그대로 반환
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
