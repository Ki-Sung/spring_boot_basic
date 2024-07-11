// 패키지 선언 - 해당 클래스가 com.example.TestProject.dto 패키지에 속해있음
package com.example.TestProject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Lombok 사용
@Getter
@Setter
@ToString
// 클래스 정의
public class MemberDTO {

    // 필드
    private String name;          // 이름
    private String email;         // 이메일
    private String organization;  // 조직

}
