package com.nimap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.entity.ProductModel;

public interface ProductService {

	Page<ProductModel> getAllProducts(Pageable pageable);

	ProductModel getProductById(Long id);

	ProductModel createProduct(ProductModel product);

	ProductModel updateProduct(Long id, ProductModel product);

	void deleteProduct(Long id);
}
