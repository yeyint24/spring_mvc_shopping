package com.example.spring_mvc_shopping.repository;

import com.example.spring_mvc_shopping.domain.Product;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategoryId(int id);


    @Query("select p from Product p where p.category.id= :id")
    List<Product> findProductByCategoryId(@Param("id")int id);

}
