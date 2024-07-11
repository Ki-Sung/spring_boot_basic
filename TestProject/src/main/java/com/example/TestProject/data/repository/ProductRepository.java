package com.example.TestProject.data.repository;

import com.example.TestProject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 - 추상 메서드들을 나열한 형태 - 클라이언트 프로그램에서 구현을 보지 않고도 객체를 사용할 수 있는 매개체 역할을 하고,
// 공통적인 목적을 갖고있는 클래스들의 틀을 제공하는 역할을 한다

// 데이터 접근 계층을 간단하게 구현하는 인터페이스 -  ProductEntity와 관련된 데이터베이스 작업을 쉽게 수행할 수 있음

// ProductEntity 클래스 선언, Spring Data JPA에서 제공하는 JpaRepository 인터페이스를 가져옴
// extends JpaRepository<ProductEntity, String>는 ProductRepository 인터페이스가 JpaRepository 인터페이스를 상속받는다는 것을 의미
// 이를 통해 JpaRepository가 제공하는 기본적인 CRUD(Create, Read, Update, Delete) 메서드를 사용할 수 있게 됨
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
