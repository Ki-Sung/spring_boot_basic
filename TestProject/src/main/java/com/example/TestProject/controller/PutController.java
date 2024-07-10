package com.example.TestProject.controller;


import com.example.TestProject.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController                             // RESTful한 컨트롤러들을 동작하기 위해 명시
@RequestMapping("/api/v1/put-api")         // 공통되는 URL을 지정 - 해당 클래스의 모든 메소드가 명시된 URL로 시작하는 URL에 매핑됨
public class PutController {

    // API 지정 - PUT API
    // PutMapping 어노테이션 사용
    // URL 체계: http://localhost:8080/api/v1/put-api/default
    @PutMapping(value = "/default")              // HTTP PUT 요청을 /api/v1/put-api/default URL로 매핑
    public String putMethod() {

        // 문자열 반환 (입력 값 X)
        return "Hello World";
    }

    // URL 체계: http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")              // HTTP PUT 요청을 /api/v1/put-api/member URL로 매핑
    public String postMember(@RequestBody Map<String, Object> postData) {   // Request Body의 데이터를 Map으로 받아 처리
        StringBuilder sb = new StringBuilder();                             // 문자열을 효율적으로 조합하기 위해 StringBuilder 객체 생성

        postData.entrySet().forEach(map -> {                                // postData의 각 항목을 반복하여 처리 - Map의 각 항목을 순회하며 키와 값을 아래의 문자열로 조합
            sb.append(map.getKey() + " : " + map.getValue() + "\n");        // key와 value를 추가하여 문자열 만들기 - 예: "key : value" \n
        });

        // 조합된 문자열을 반환
        return sb.toString();
    }

    // DTO 방식 1
    // // URL 체계: http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")                                    // HTTP PUT 요청을 /api/v1/put-api/member1 URL로 매핑
    public String postMemberDto1(@RequestBody MemberDTO memberDTO) {   // Request Body의 데이터를 MemberDTO 객체로 받아 처리하는 메서드

        // MemberDTO 객체의 toString() 메서드를 호출하여 반환
        return memberDTO.toString();
    }

    // DTO 방식 2
    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")                                       // HTTP PUT 요청을 /api/v1/put-api/member2 URL로 매핑
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO) {   // Request Body의 데이터를 MemberDTO 객체로 받아 처리하는 메서드

        // MemberDTO로 반환
        return memberDTO;
    }

    // DTO 방식 3
    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")                                                        // HTTP PUT 요청을 /api/v1/put-api/member3 URL로 매핑
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO) {   // 반환 타입이 ResponseEntity<MemberDTO>인 공개 메서드 Request Body를 MemberDTO 객체로 받음

        // HTTP 상태 코드202 Accpeted와 함께 MemberDTO 객체를 ResponseEntity로 반환
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }

}
