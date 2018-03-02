package com.truxton.RestAPI.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.truxton.RestAPI.models.Product;
import com.truxton.RestAPI.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	public ProductResource(ProductService service) {

     this.service = service;
	}

	@GetMapping
	@ResponseBody
	public List<Product> listAll() {
		return this.service.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Product findOne(@PathVariable("id") Long id) {
		return this.service.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code=HttpStatus.CREATED)
	public Product create(@RequestBody Product products) {
		
		return this.service.create(products);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
		Product productExists =this.service.findOne(id);
		if(productExists != null) {
			product.setId(productExists.getId());
			this.service.create(product);
			return product;
		}
		return null;
		
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
		
	}
}
