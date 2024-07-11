package com.example.TestProject.data.dto;

import com.example.TestProject.data.entity.ProductEntity;
import lombok.*;

// 상품 정보를 담고 다른 계층 간에 데이터를 전송
// DTO와 Entity 간의 변환을 통해 데이터베이스와 상호작용을 더 쉽게 관리할 수 있음

// 어노테이션
@Data                       // getter, setter, toString, equals, hashCode 메서드를 자동으로 생성
@NoArgsConstructor          // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@AllArgsConstructor         // 모든 필드를 매개변수로 가지는 생성자를 자동으로 생성
@ToString                   // 클래스의 모든 필드를 포함한 toString 메서드를 자동으로 생성
@Builder                    // 빌더 패턴을 사용하여 객체를 생성할 수 있게 함
public class ProductDto {   // ProductDto라는 이름의 공개 클래스 정의

    // 클래스의 필드(변수)를 정의 - 상품의 특정한 속성 정의
    private String productId;           // 상품 ID
    private String productName;         // 상품명
    private int productPrice;           // 상품 가격
    private int productStock;           // 상품 재고 수량

    // toEntity 메서드를 정의 - ProductDto 객체를 ProductEntity 객체로 변환하는 역할
    public ProductEntity toEntity() {
        return ProductEntity.builder()          // ProductEntity의 빌더를 사용하여 새로운 ProductEntity 객체를 생성 후,  ProductDto 객체의 필드 값을 사용하여 초기화
                .productId(productId)           // ProductDto 객체의 productId 값을 ProductEntity 객체의 productId 필드에 설정
                .productName(productName)       // ProductDto 객체의 productName 값을 ProductEntity 객체의 productName 필드에 설정
                .productPrice(productPrice)     // ProductDto 객체의 productPrice 값을 ProductEntity 객체의 productPrice 필드에 설정
                .productStock(productStock)     // ProductDto 객체의 productStock 값을 ProductEntity 객체의 productStock 필드에 설정
                .build();                       // 설정된 필드 값들로 새로운 ProductEntity 객체를 생성
    }

}
