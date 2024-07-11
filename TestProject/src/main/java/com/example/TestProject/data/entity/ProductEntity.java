package com.example.TestProject.data.entity;

import com.example.TestProject.data.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;

// 데이터베이스 엔티티 정의 -  데이터베이스 테이블과 매핑되는 엔티티를 정의
// 상품(Product)의 정보를 담고 있으며, 이는 데이터베이스의 product 테이블과 매핑됨
// 데이터베이스와의 상호작용을 관리하고, 엔티티와 DTO 간의 변환을 통해 데이터 전송을 용이하게 함

@Entity                         // 해당 클래스가 JPA 엔티티임을 명시 즉, 데이터베이스 테이블과 매핑
@Getter                         // 모든 필드에 대해 getter 메서드를 자동으로 생성
@Setter                         // 모든 필드에 대해 setter 메서드를 자동으로 생성
@NoArgsConstructor              // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@AllArgsConstructor             // 모든 필드를 매개변수로 가지는 생성자를 자동으로 생성
@Builder                        // 빌더 패턴을 사용하여 객체를 생성할 수 있게 함
@Table(name = "product")        // 데이터베이스의 product 테이블과 매핑됨
public class ProductEntity {    // ProductEntity 라는 클래스 정의

    // 클래스의 필드(변수)를 정의 - 각각의 필드는 상품의 특정한 속성을 나타냄
    @Id                         // 해당 필드가 데이터베이스 테이블의 기본 키임을 나타냄
    String productId;           // 상품의 ID를 저장하는 문자열 필드(변수)
    String productName;         // 상품명을 저장하는 문자열 필드(변수)
    Integer productPrice;       // 상품 가격을 저장하는 정수형 필드(변수)
    Integer productStock;       // 상품의 재고 수량을 저장하는 정수형 필드(변수)

    // toDto라는 메서드를 정의 - ProductDto의 빌더를 사용하여 새로운 ProductDto 객체를 생성, ProductEntity 객체의 필드 값을 사용하여 초기화 함
    public ProductDto toDto() {
        return ProductDto.builder()             // ProductDto 클래스의 빌더 호출
                .productId(productId)           // ProductEntity 객체의 productId 값 -> ProductDto 객체의 productId 필드에 설정
                .productName(productName)       // ProductEntity 객체의 productName 값 -> ProductDto 객체의 productName 필드에 설정
                .productPrice(productPrice)     // ProductEntity 객체의 productPrice 값 -> ProductDto 객체의 productPrice 필드에 설정
                .productStock(productStock)     // ProductEntity 객체의 productStock 값 -> ProductDto 객체의 productStock 필드에 설정
                .build();                       // 설정된 필드 값들로 새로운 ProductDto 객체를 생성
    }

}
