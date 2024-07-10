package com.example.TestProject.controller;

import com.example.TestProject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController                             // RESTful한 컨트롤러들을 동작하기 위해 명시
@RequestMapping("/api/v1/post-api")         // 공통되는 URL을 지정 - 해당 클래스의 모든 메소드가 명시된 URL로 시작하는 URL에 매핑됨
public class PostController {

    // API 지정 - POST API

    // PostMapping 어노테이션 사용
    // URL 체계: http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")        // HTTP POST 요청을 /api/v1/post-api/default URL로 매핑
    public String postMethod() {

        // 문자열 반환 (입력 값 X)
        return "Hello World";
    }

    // URL 체계: http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")         // HTTP POST 요청을 /api/v1/post-api/member URL로 매핑
    public String postMember(@RequestBody Map<String, Object> postData) {   // Request Body의 데이터를 Map으로 받아 처리
        StringBuilder sb = new StringBuilder();                             // 문자열을 효율적으로 조합하기 위해 사용

        postData.entrySet().forEach(map -> {                                // Map의 각 항목을 순회하며 키와 값을 아래의 문자열로 조합
            sb.append(map.getKey() + " : " + map.getValue() + "\n");        // 예: "key : value" \n
        });

        /*
        param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
        */

        // 조합된 문자열을 반환
        return sb.toString();
    }

    // URL 체계: http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")                                  // HTTP POST 요청을 /api/v1/post-api/member2 URL로 매핑
    public String postMemberDTO(@RequestBody MemberDTO memberDTO) {   // Request Body의 데이터를 MemberDTO 객체로 받아 처리하는 메서드

        // MemberDTO 객체의 toString() 메서드를 호출하여 반환
        return memberDTO.toString();
    }

}
