package br.com.anderson.RestAPI.services;

import br.com.anderson.RestAPI.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findOne(Long id);

    public Product create(Product product);

    public Product update(Long id, Product product);

    public void delete(Long id);

}
