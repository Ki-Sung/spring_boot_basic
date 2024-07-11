package com.example.TestProject.handler;

import com.example.TestProject.data.entity.ProductEntity;

//  제품 정보를 저장하고 조회하는 두 가지 메서드를 정의

// ProductDataHandler 인터페이스를 선언
public interface ProductDataHandler {

    // 제품 정보를 저장하는 메서드 정의 - 해당 메서드는 제품 ID, 이름, 가격, 재고 수량을 매개변수로 받고, ProductEntity 객체를 반환
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    // 제품 ID를 기반으로 제품 정보를 가져오는 메서드 정의 - 해당 메서드는 제품 ID를 매개변수로 받고, ProductEntity 객체를 반환
    ProductEntity getProductEntity(String productId);
}
