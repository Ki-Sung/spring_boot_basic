package com.example.TestProject.controller;

import com.example.TestProject.common.Constants;
import com.example.TestProject.common.exception.TestProjectException;
import com.example.TestProject.data.dto.ProductDto;
import com.example.TestProject.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// RESTful API 를 통해 제품 정보를 가져오간 생성하는 기능 제공
// Logger 추가

@RestController                             // 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 명시
@RequestMapping("/api/v1/product-api")      // 해당 컨트롤러의 모든 요청 URL 앞에 "/api/v1/product-api"가 붙음
public class ProductController {            // ProductController 클래스 선언

    // 로그 메시지를 기록하는 데 사용될 LOGGER 변수 선언 - ProductController 클래스에 대한 로거 인스턴스 생성
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    // ProductService 타입의 productService라는 변수를 선언 - 해당 변수는 제품 관련 비지니스 로직을 처리하는 클래스
    private ProductService productService;

    // 생성자와 의존성 주입
    @Autowired                              // 스프링이 ProductService 객체를 자동으로 주입하도록 함 - 이 어노테이션을 통해 스프링은 ProductService의 인스턴스를 productService 변수에 할당
    public ProductController(ProductService productService) {  // ProductController 객체 생성

        this.productService = productService;           // ProductService 객체를 받아 productService 변수에 할당
    }

    // GET 요청 처리 메서드
    // GET 방식 - 특정 제품 정보를 가져오기 위한 API
    // API URL 체계: http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")             // HTTP GET 요청이 지정된 URL로 들어오면 해당 메서드가 호출 - {productId}는 URL 경로의 일부로 동적인 값을 받을 수 있음
    public ProductDto getProduct(@PathVariable String productId) {  // @PathVariable은 URL 경로에서 productId 값을 추출하여 메서드의 매개변수로 전달

        // 메서드 내부 로직
        long startTime = System.currentTimeMillis();                // 현재 시간을 밀리초 단위로 기록하여 startTime 변수에 저장 - API 응답 시간 측정에 사용
        LOGGER.info("[ProductController] perform {} Gilbert Test API.", "getProduct");      // INFO 레벨의 로그 메시지를 기록

        ProductDto productDto = productService.getProduct(productId);   // productService 객체의 getProduct 메서드를 호출하여 productId에 해당하는 제품 정보를 가져오기

        // 제품 정보를 포함한 응답 로그를 기록 - 제품 ID, 이름, 가격, 재고, 그리고 응답 시간이 포함
        LOGGER.info("[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
                (System.currentTimeMillis() - startTime));

        // ProductDto 객체 반환 - 이 객체는 클라이언트에게 제품 정보를 제공
        return productDto;
    }

    // POST 요청 처리 메서드
    // POST 방식 - 새로운 제품 등록을 위한 API
    // API URL 체계: http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")                        //  HTTP POST 요청이 지정된 URL로 들어오면 해당 메서드가 호출
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {    // ProductDto 객체를 받아 ResponseEntity<ProductDto> 객체를 반환 - 유효성 검사

        long startTime = System.currentTimeMillis();            // 현재 시간을 밀리초 단위로 기록하여 startTime 변수에 저장 - API 응답 시간 측정에 사용

        String productId = productDto.getProductId();           // ProductDto 객체에서 제품 ID 저장
        String productName = productDto.getProductName();       // ProductDto 객체에서 제품명 저장
        int productPrice = productDto.getProductPrice();        // ProductDto 객체에서 제품 가격 저장
        int productStock = productDto.getProductStock();        // ProductDto 객체에서 제품 재고 수량 저장

        // 제품 저장
        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);  // productService 객체의 saveProduct 메서드를 호출하여 제품 정보를 저장

        // 제품 정보를 포함한 응답 로그를 기록 - 제품 ID, 이름, 가격, 재고, 그리고 응답 시간이 포함
        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}, Response Time = {}ms",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock(),
                (System.currentTimeMillis() - startTime));

        // HTTP 응답 상태 코드를 OK(200)로 설정하고, response 객체를 응답 본문으로 설정하여 반환
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/product/exception")                          // 해당 메서드가 HTTP POST 요청을 처리함을 명시 - 요청 URL: /product/exception
    public void exceptionTest() throws TestProjectException {           // 메서든 선언 - TestProjectException 예외를 던질 수 있음
        throw new TestProjectException(Constants.ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "의도한 에러가 발생했습니다."); // 새로운 TestProjectException 예외를 생성하고 던짐
    }

    /*
    // API URL 체계: http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }
     */

}
