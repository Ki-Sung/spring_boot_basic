package com.example.TestProject.data.dao.impl;

import com.example.TestProject.data.dao.ProductDAO;
import com.example.TestProject.data.entity.ProductEntity;
import com.example.TestProject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ProductDAO 인터페이스의 메서드들을 실제로 구현하여 데이터베이스와의 상호작용을 담당 -
// ProductRepository를 사용하여 데이터베이스 작업을 수행하며, 스프링 프레임워크의 의존성 주입을 통해 필요한 객체들을 자동으로 주입 받음

// ProductImpl라는 이름의 클래스를 정의
@Service                                            // 서비스 레이어의 역할을 한다는 것을 스프링 프레임워크에 알림
public class ProductImpl implements ProductDAO {    // ProductImpl 클래스 정의, 해당 클래스가 ProductDAO 인터페이스를 구현함

    // ProductRepository 타입의 productRepository 변수를 선언 - 데이터 베이스 작업을 수행하는데 사용
    ProductRepository productRepository;

    // ProductImpl 클래스의 생성자를 정의
    @Autowired                                                 // 스프링 프레임워크가 ProductRepository 객체를 자동으로 주입하도록 함
    public ProductImpl(ProductRepository productRepository) {  // ProductRepository 객체를 매개변수로 받아서 productRepository 변수에 할당
        this.productRepository = productRepository;            // 전달받은 productRepository 객체를 클래스의 productRepository 변수에 할당
    }

    // ProductDAO 인터페이스의 saveProduct 메서드를 구현
    @Override                                                           // 부모 인터페이스(ProductDAO)의 메서드를 재정의하고 있다는 것을 나타냄
    public ProductEntity saveProduct(ProductEntity productEntity) {     // saveProduct 메서드는 ProductEntity 객체를 매개변수로 받아서 저장하고, 저장된 객체를 반환
        productRepository.save(productEntity);                          // productRepository의 save 메서드를 호출하여 productEntity를 데이터베이스에 저장
        return productEntity;                                           // 저장된 productEntity 객체를 반환
    }

    // ProductDAO 인터페이스의 getProduct 메서드를 구현
    @Override                                               // 부모 인터페이스(ProductDAO)의 메서드를 재정의하고 있다는 것을 나타냄
    public ProductEntity getProduct(String productId) {     // getProduct 메서드는 String 타입의 productId를 매개변수로 받아서 해당 ProductEntity 객체를 반환
        ProductEntity productEntity = productRepository.getById(productId); // productRepository의 getById 메서드를 호출하여 productId에 해당하는 ProductEntity 객체를 가져옴
        return productEntity;                               // 가져온 productEntity 객체를 반환
    }
}
