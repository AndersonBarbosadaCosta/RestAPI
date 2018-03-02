package com.truxton.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truxton.RestAPI.models.Product;

@Repository
public interface Products extends JpaRepository<Product, Long> {

}
