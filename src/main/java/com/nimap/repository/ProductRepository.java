package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.entity.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
