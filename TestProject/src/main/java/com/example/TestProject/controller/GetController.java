package com.example.TestProject.controller;

import com.example.TestProject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController                     // RESTful한 컨트롤러들을 동작하기 위해 명시
@RequestMapping("/api/v1/get-api")  // 공통되는 URL을 지정
public class GetController {

    // API 지정

    // RequestMapping 어노에티션 사용 - 이전 방식
    // URL 체계: http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        // GET으로 호출 시 아래의 return 값을 응답 받음
        return "Hello World";
    }

    // GetMapping 어노테이션 사용 - 최근 방식
    // URL 체계: http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        // GET으로 호출 시 아래의 return 값을 응답 받음
        return "Gilbert";
    }

    // PathVariable 방식 사용 - 방법 1 - 변수 이름과 메소드의 매개변수를 일치 시키는 방식
    // URL 체계: http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        // GET 호출 시 들어온 String 값을 응답 받음
        return variable;
    }

    // PathVariable 방식 사용 - 방법 2 - 변수 이름과 메소드의 매개변수가 다를 경우 사용하는 방식
    // URL 체계: http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        // GET 호출 시 들어온 String 값을 응답 받음
        return var;
    }

    // ReqeustPram 방식 사용 - 방법 1 - key, value에 어떤 요청 값이 들어갈지 정해져 있는 경우
    // 파라미터
    // name=gilbert
    // email=gilbert@test.com
    // organization=a1perfact
    // URL 체계: http://localhost:8080/api/v1/get-api/request1?name=gilbert&email=gilbert@test.com&organization=a1perfact
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        // GET 호출 시 들어온 파라미터 값들을 응답 받음
        return name + " " + email + " " + organization;
    }

    // ReqeustPram 방식 사용 - 방법 2 - key, value에 어떤 요청 값이 들어갈지 모를 경우 사용
    // URL 체계: http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    // GET 요청과 함꼐 전달된 모든 요청 매개변수를 Map<String, String> 타입의 param 변수로 받음
    public String getRequestParam2(@RequestParam Map <String, String> param) {
        // 처리하는 로직 넣기
        StringBuilder sb = new StringBuilder();                       // 응답 문자열을 효율적으로 생성하기 위해 StringBuilder 객체 초기화

        param.entrySet().forEach(map -> {                             // param 맵의 모든 엔트리(키-값)를 반복 - 각 엔트리마다 키와 값을 StringBuilder에 추가
           sb.append(map.getKey() + " : " + map.getValue() + "\n");   // 각 키-값 쌍을 key : value 형식으로 StringBuilder에 추가
        });

        // StringBuilder에 추가된 모든 문자열을 하나의 문자열로 변환하여 반환
        return sb.toString();
    }

    // DTO 사용 - 쿼리 문자열을 전달하기 위해 사용되는 방식
    // URL 체계: http://localhost:8080/api/v1/get-api/request3?name=gilbert&email=gilbert@test.com&organization=a1perfact
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO) {    // MemberDTO 메서드 사용
        // return methodDTO.getName() + " " + methodDTO.getEmail() + " " + methodDTO.getOrganization()
        return memberDTO.toString();
    }

}
