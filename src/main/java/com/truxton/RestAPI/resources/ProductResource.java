package com.truxton.RestAPI.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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
	public ResponseEntity<?> listAll() {
		List<Product> produtos = this.service.findAll();
		
		return new ResponseEntity<List>(produtos,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
		Product product = this.service.findOne(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Product products, Errors errors) {
		if (!errors.hasErrors()) {
			Product productCreated = this.service.create(products);
			return new ResponseEntity<Product>(productCreated,HttpStatus.CREATED);
		}

		return ResponseEntity.badRequest().body(
				errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));

	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Product product,Errors errors) {
		Product productExists = this.service.findOne(id);
		if (productExists != null && !errors.hasErrors()) {
			product.setId(productExists.getId());
			Product productUpdate = this.service.create(product);
			return new ResponseEntity<Product>(productUpdate,HttpStatus.OK);
		}
		return ResponseEntity.badRequest().body(
				errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));


	}

	@DeleteMapping("/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);

	}
}
