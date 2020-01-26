package com.example.spring_mvc_shopping.repository;

import com.example.spring_mvc_shopping.domain.Product;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
