package com.erpcooli.catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erpcooli.catalog.document.Product;
import com.erpcooli.catalog.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	public Product findOneById(String id) {
		return this.productRepository.findOneById(id);
	}
	
	public Product addProduct(Product product) {
		product.setId(null);
		return this.productRepository.save(product);
	}
	
	public Product editProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public Product deleteProduct(Product product) {
		this.productRepository.delete(product);
		return product;
	}
}
