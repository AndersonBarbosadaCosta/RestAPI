package com.truxton.RestAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truxton.RestAPI.models.Product;
import com.truxton.RestAPI.repository.Products;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private Products repository;
	
	public ProductServiceImpl(Products repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> findAll() {
		
		return this.repository.findAll();
	}

	@Override
	public Product findOne(Long id) {
		
		Product product= this.repository.findOne(id);
		return product;
	}

	@Override
	public Product create(Product product) {
		
		return this.repository.save(product);
	}

	@Override
	public Product update(Long id, Product product) {
	   Product productUpdate = findOne(id);
	   if(productUpdate != null) {
		   
	   }
		return null;
	}

	@Override
	public void delete(Long id) {
		Product product = findOne(id);
		if(product != null) {
			this.repository.delete(product);
		}
		
		
	}

}
