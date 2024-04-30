package com.nimap.service;

import com.nimap.entity.ProductModel;
import com.nimap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<ProductModel> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public ProductModel getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public ProductModel createProduct(ProductModel product) {
		return productRepository.save(product);
	}

	@Override
	public ProductModel updateProduct(Long id, ProductModel product) {
		if (productRepository.existsById(id)) {
			product.setId(id);
			return productRepository.save(product);
		} else {
			return null;
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
