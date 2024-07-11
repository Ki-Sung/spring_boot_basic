package com.example.TestProject.handler.impl;

import com.example.TestProject.data.dao.ProductDAO;
import com.example.TestProject.data.entity.ProductEntity;
import com.example.TestProject.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ProductDataHandlerImpl 클래스는 ProductDataHandler 인터페이스를 구현하여 실제로 제품 데이터를 데이터베이스에 저장하고 조회하는 로직 구성
// 해당 클래스는 ProductDAO를 사용하여 데이터베이스와 상호작용 함
// saveProductEntity 메서드는 새로운 제품 정보를 데이터베이스에 저장
// getProductEntity 메서드는 제품 ID를 기반으로 제품 정보를 데이터베이스에서 조회


@Service                        // 해당 클래스가 스프링의 서비스 컴포넌트임을 명시
@Transactional                  // 해당 클래스의 메서드가 트랜잭션 내에서 실행됨을 나타냄
public class ProductDataHandlerImpl implements ProductDataHandler {     //  ProductDataHandler 인터페이스를 구현하는 ProductDataHandlerImpl 클래스를 선언

    // ProductDAO 타입의 productDAO라는 변수 선언 - 해당 변수는 데이터베이스와 상호작용하는 데이터 접근 객체
    ProductDAO productDAO;

    @Autowired                  // 스프링이 ProductDAO 객체를 자동으로 주입하도록 함
    public ProductDataHandlerImpl(ProductDAO productDAO) {      // ProductDataHandlerImpl 객체 생성

        // 객체가 생성 뙬 때, ProductDAO 객체를 받아 productDAO 변수에 할당
        this.productDAO = productDAO;
    }

    @Override                   // 해당 메서드가 ProductDataHandler 인터페이스의 메서드를 구현하고 있음을 나타냄
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {  // 제품 정보를 저장하는 메서드

        // 새로운 ProductEntity 객체를 생성하고, 매개변수로 받은 제품 정보를 설정
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        // productDAO를 사용하여 productEntity 객체를 데이터베이스에 저장하고, 저장된 ProductEntity 객체를 반환
        return productDAO.saveProduct(productEntity);
    }

    @Override                   // 해당 메서드가 ProductDataHandler 인터페이스의 메서드를 구현하고 있음을 나타냄
    public  ProductEntity getProductEntity(String productId) {      // 제품 ID를 기반으로 제품 정보를 가져오는 메서드

        // productDAO를 사용하여 제품 ID에 해당하는 제품 정보를 데이터베이스에서 가져오고, ProductEntity 객체를 반환
        return productDAO.getProduct(productId);
    }
}
