package com.example.TestProject.common;

public class Constants {                        // 상수나 공통적으로 사용되는 값을 정의하는데 사용될 클래스

    public enum ExceptionClass {                // 중첩 열거형 선언
        PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider");   // ExceptionClass 열거형에 세 가지 값(PRODUCT, ORDER, PROVIDER)을 정의 - 각 값은 문자열을 매개변수로 받음

        // 필드 선언
        private String exceptionClass;              // 열거형 값의 문자열 표현을 저장

        // 생성자 선언
        ExceptionClass(String exceptionClass) {     // exceptionClass 필드를 초기화
            this.exceptionClass = exceptionClass;   // 인스턴스 변수 exceptionClass를 매개변수로 전달된 값으로 초기화
        }

        public String getExceptionClass() {         // exceptionClass 필드를 반환하는 퍼블릭 게터 메서드
            return exceptionClass;
        }

        @Override                                   // 부모 클래스(Object 클래스)의 toString 메서드를 재정의(오버라이드)하고 있음
        public String toString() {                  // toString 메서드를 재정의
            return getExceptionClass() + " Exception. ";    // exceptionClass 필드의 값과 " Exception. " 문자열을 결합한 문자열을 반환
        }
    }
}
