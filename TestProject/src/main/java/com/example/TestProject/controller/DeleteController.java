package com.example.TestProject.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                                  // RESTful한 컨트롤러들을 동작하기 위해 명시
@RequestMapping(value = "/api/v1/get-api")       // // 공통되는 URL을 지정 - 해당 클래스의 모든 메소드가 명시된 URL로 시작하는 URL에 매핑됨
public class DeleteController {

    // API 지정 - DELETE API
    // DeleteMapping 어노테이션 사용
    // URL 체계: http://localhost:8080/api/v1/get-api/delete/{variable}
    @DeleteMapping(value = "/delete/{variable}")                    // HTTP DELETE 요청을 /api/v1/get-api/delete/{variable} URL로 매핑
    public String DeleteVariable(@PathVariable String variable) {   // URL 경로에서 variable 부분을 메서드의 인자로 전달 받도록 함
        //전달 받은 variable 값을 그대로 반환
        return variable;
    }
}
