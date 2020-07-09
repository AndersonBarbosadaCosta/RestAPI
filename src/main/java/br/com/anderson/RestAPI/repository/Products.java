package br.com.anderson.RestAPI.repository;

import br.com.anderson.RestAPI.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products extends JpaRepository<Product, Long> {

}
