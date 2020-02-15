package com.catalogue.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.catalogue.product.model.Category;
import com.catalogue.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Iterable<Product> findBycategory(Category category);
	Product findByProductName(String name);

}
