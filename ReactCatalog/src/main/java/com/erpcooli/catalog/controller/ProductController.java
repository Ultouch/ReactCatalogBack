package com.erpcooli.catalog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erpcooli.catalog.document.Product;
import com.erpcooli.catalog.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall() throws JsonProcessingException{
        Map<String, Object> response = new HashMap<>();
        response.put("products", this.productService.findAll());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getproduct/{id}")
	public ResponseEntity<?> getproduct(@PathVariable("id") String id) throws JsonProcessingException{
        Map<String, Object> response = new HashMap<>();
        Product product = this.productService.findOneById(id);
		response.put("product", product);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<?> addproduct(@RequestBody Product p) throws JsonProcessingException{
        Map<String, Object> response = new HashMap<>();
        Product product = new Product();
        product.setCode(p.getCode());
        product.setLabel(p.getLabel());
        product.setPrice(p.getPrice());
        product = this.productService.addProduct(product);
		response.put("product", product);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/editproduct")
	public ResponseEntity<?> editproduct(@RequestBody Product p) throws JsonProcessingException{
        Map<String, Object> response = new HashMap<>();
        Product product = this.productService.findOneById(p.getId());
        product.setCode(p.getCode());
        product.setLabel(p.getLabel());
        product.setPrice(p.getPrice());
        product = this.productService.editProduct(product);
		response.put("product", product);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<?> deleteproduct(@PathVariable("id") String id) throws JsonProcessingException{
        Map<String, Object> response = new HashMap<>();
        Product product = this.productService.findOneById(id);
        product = this.productService.deleteProduct(product);
		response.put("product", product);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
