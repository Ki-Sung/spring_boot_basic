package com.example.TestProject.service.impl;

import com.example.TestProject.data.dto.ProductDto;
import com.example.TestProject.data.entity.ProductEntity;
import com.example.TestProject.service.ProductService;
import com.example.TestProject.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ProductServiceImpl 클래스는 이 인터페이스를 구현하여 실제로 제품을 저장하고 조회하는 로직을 작성
// 해당 클래스는 ProductDataHandler를 사용하여 데이터베이스와 상호작용을 함
// saveProduct 메서드는 제품 정보를 저장하고, getProduct 메서드는 제품 ID를 기반으로 제품 정보를 조회


@Service                                                        // 해당 클래스가 스프링의 서비스 컴포넌트임을 명시 - 스프링이 해당 클래스를 서비스로 관리함
public class ProductServiceImpl implements ProductService {     // ProductService 인터페이스를 구현하는 ProductServiceImpl 클래스 선언

    // ProductDataHandler 타입의 productDataHandler 변수 선언
    ProductDataHandler productDataHandler;

    @Autowired                                                  // 스프링이 ProductDataHandler 객체를 자동으로 주입하도록 함
    public ProductServiceImpl(ProductDataHandler productDataHandler) {  // ProductServiceImpl 객체 생성

        this.productDataHandler = productDataHandler;           // 객체가 생성 될 때 ProductDataHandler 객체를 받아 productDataHandler 변수에 할당
    }

    @Override                                                   // 해당 메서드가 ProductService 인터페이스의 메서드를 구현하고 있음을 나타냄
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {   // 제품을 저장하는 메서드

        // productDataHandler를 사용하여 제품 정보를 저장하고, 저장된 ProductEntity 객체를 반환
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        // ProductEntity 객체에서 정보를 추출하여 새로운 ProductDto 객체를 생성
        ProductDto productDto = new ProductDto(productEntity.getProductId(),        // 제품 ID
                                                productEntity.getProductName(),     // 제품명
                                                productEntity.getProductPrice(),    // 제품 가격
                                                productEntity.getProductStock());   // 제품 재고 수량

        // 생성된 productDto 객체 반환
        return productDto;
    }

    @Override                                           // 해당 메서드가 ProductService 인터페이스의 메서드를 구현하고 있음을 나타냄
    public ProductDto getProduct(String productId) {    // 제품 ID를 기반으로 제품 정보를 가져오는 메서드

        // productDataHandler를 사용하여 제품 정보를 가져오고, ProductEntity 객체를 반환 받음
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        // ProductEntity 객체에서 정보를 추출하여 새로운 ProductDto 객체를 생성
        ProductDto productDto = new ProductDto(productEntity.getProductId(),        // 제품 ID
                                                productEntity.getProductName(),     // 제품명
                                                productEntity.getProductPrice(),    // 제품 가격
                                                productEntity.getProductStock());   // 제품 재고 수량

        // 생성된 productDto 객체 반환
        return productDto;
    }
}
