// 패키지 선언 - 해당 클래스가 com.example.TestProject.dto 패키지에 속해있음
package com.example.TestProject.dto;

// 클래스 정의
public class MemberDTO {
    private String name;          // 이름
    private String email;         // 이메일
    private String organization;  // 조직

    // name 필드의 값을 반환하는 getName 메서드
    public String getName() {
        return name;
    }

    // name 필드의 값을 설정하는 setName 메서드
    public void setName(String name) {
        this.name = name;
    }

    // email 필드의 값을 반환하는 getEmail 메서드
    public String getEmail() {
        return email;
    }

    // email 필드의 값을 설정하는 setEmail 메서드
    public void setEmail(String email) {
        this.email = email;
    }

    // organization 필드의 값을 반환하는 getOrganization 메서드
    public String getOrganization() {
        return organization;
    }

    // organization 필드의 값을 설정하는 setOrganization 메서드
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    // Gegerate -> toString
    // toString 메서드를 오버라이드하여 MemberDTO 객체를 문자열로 표현
    // 이 메서드는 객체의 각 필드 값을 포함한 문자열 반환
    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
