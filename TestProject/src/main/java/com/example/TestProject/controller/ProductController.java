package com.example.TestProject.controller;

import com.example.TestProject.data.dto.ProductDto;
import com.example.TestProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// RESTful API 를 통해 제품 정보를 가져오간 생성하는 기능 제공

@RestController                             // 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 명시
@RequestMapping("/api/v1/product-api")      // 해당 컨트롤러의 모든 요청 URL 앞에 "/api/v1/product-api"가 붙음
public class ProductController {            // ProductController 클래스 선언

    // ProductService 타입의 productService라는 변수를 선언 - 해당 변수는 제품 관련 비지니스 로직을 처리하는 클래스
    private ProductService productService;

    @Autowired                              // 스프링이 ProductService 객체를 자동으로 주입하도록 함 - 이 어노테이션을 통해 스프링은 ProductService의 인스턴스를 productService 변수에 할당
    public ProductController(ProductService productService) {  // ProductController 객체 생성

        this.productService = productService;           // ProductService 객체를 받아 productService 변수에 할당
    }

    // GET 방식 - 특정 제품 정보를 가져오기 위한 API
    // API URL 체계: http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")             // HTTP GET 요청이 지정된 URL로 들어오면 해당 메서드가 호출 - {productId}는 URL 경로의 일부로 동적인 값을 받을 수 있음
    public ProductDto getProduct(@PathVariable String productId) {  // @PathVariable은 URL 경로에서 productId 값을 추출하여 메서드의 매개변수로 전달

        return productService.getProduct(productId);        // productId를 이용해 productService에서 제품 정보를 가져와 반환
    }

    // POST 방식 - 새로운 제품 등록을 위한 API
    // API URL 체계: http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")                        //  HTTP POST 요청이 지정된 URL로 들어오면 해당 메서드가 호출
    public ProductDto createProduct(@RequestBody ProductDto productDto) {    // @RequestBody는 요청 본문에서 ProductDto 객체를 추출하여 매개변수로 전달 -> 제품 등록

        String productId = productDto.getProductId();           // ProductDto 객체에서 제품 ID 저장
        String productName = productDto.getProductName();       // ProductDto 객체에서 제품명 저장
        int productPrice = productDto.getProductPrice();        // ProductDto 객체에서 제품 가격 저장
        int productStock = productDto.getProductStock();        // ProductDto 객체에서 제품 재고 수량 저장

        // productService의 saveProduct 메서드를 호출하여 제품 정보를 저장하고, 저장된 제품 정보를 반환
        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    /*
    // API URL 체계: http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }
     */

}
