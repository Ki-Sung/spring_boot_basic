package com.example.TestProject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Spring Boot에서 Swagger를 사용하여 API 문서 자동 생성
@Configuration                                  // Spring 설정 클래스임을 명시 - Bean들은 Spring 컨텍스트에 의해 관리 됨
public class OpenApiConfiguration {

    @Bean                                       // 해당 어노테이션이 메서드가 반환하는 객체가 Spring 컨텍스트에 의해 관리되는 Bean임을 명시
    public OpenAPI customOpenAPI() {                       // OpenAPI의 주요 구성 요소 중 하나로 OpenAPI 설정 정의
        return new OpenAPI()
                .info(new Info()                             // API 문서의 기본 정보를 설정
                .title("Gilbert Open API Test with OpenAPI") // API 문서의 제목을 설정
                .description("Spring-Boot Test API Document for OpenAPI") // API 문서 설명 설정
                .version("1.0")); // API 문서 버전 설정
    }

    @Bean                                   // 해당 어노테이션이 메서드가 반환하는 객체가 Spring 컨텍스트에 의해 관리되는 Bean임을 명시
    public GroupedOpenApi publicApi() {     // GroupedOpenApi 객체를 생성하여 반환 - OpenAPI 문서 내에서 API 엔드포인트를 그룹화하는데 사용
        return GroupedOpenApi.builder()     // GroupedOpenApi 객체를 빌드하기 위한 빌더를 생성 - 빌더 패턴을 사용하여 객체를 구성
                .group("public")            // OpenAPI 문서 내에서 API 엔드포인트를 그룹화할 때 사용할 그룹 이름을 지정
                .pathsToMatch("/**")        // OpenAPI 문서에 포함될 경로를 지정 - 여기서는 모든 경로(/**)를 매칭하도록 설정
                .packagesToScan("com.example.TestProject")  // OpenAPI 문서에 포함될 엔드포인트가 정의된 패키지를 지정
                .build();                   // 빌드 후 GroupedOpenApi 객체 생성
    }
}
