package com.truxton.RestAPI.services;

import java.util.List;

import com.truxton.RestAPI.models.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product findOne(Long id);

	public Product create(Product product);

	public Product update(Long id, Product product);

	public void delete(Long id);

}
