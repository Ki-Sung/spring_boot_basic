package com.example.TestProject.service;

import com.example.TestProject.data.dto.ProductDto;

// ProductService 인터페이스는 제품을 저장하고 조회하는 두 가지 메서드를 정의

// ProductService 인터페이스 선언 - 인터페이스는 메서드의 시그니처(이름, 반환 유형, 매개변수)를 정의하지만, 실제 구현은 포함하지 않음
public interface ProductService {

    // 제품을 저장하는 메서드 정의 - 해당 메서드는 제품 ID, 이름, 가격, 재고 수량을 매개변수로 받고, ProductDto 객체를 반환
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    // 제품 ID를 기반으로 제품 정보를 가져오는 메서드 정의 - 해당 메서드는 제품 ID를 매개변수로 받고, ProductDto 객체를 반환
    ProductDto getProduct(String productId);
}
