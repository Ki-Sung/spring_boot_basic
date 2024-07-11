package com.example.TestProject.data.dao;

import com.example.TestProject.data.entity.ProductEntity;


// 데이터베이스 접근 계층에서 ProductEntity와 관련된 작업을 수행하는 데 사용
// 이는 데이터베이스와의 상호작용을 추상화하여 나중에 데이터베이스가 변경되더라도 코드의 다른 부분에 영향을 주지 않고 쉽게 변경할 수 있도록 해줌

// ProductDAO 인터페이스를 정의 - 인터페이스는 클래스와 달리 메서드의 구현 없이 메서드의 시그니처만을 정의
public interface ProductDAO {

    //saveProduct라는 메서드의 시그니처를 정의
    ProductEntity saveProduct(ProductEntity productEntity);  // ProductEntity 객체를 데이터베이스에 저장하는 역할

    ProductEntity getProduct(String productId);              // 주어진 productId에 해당하는 ProductEntity 객체를 데이터베이스에서 조회하는 역할
}
