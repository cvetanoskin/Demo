package com.example.demo.Exercises.repository;

import com.example.demo.Exercises.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
