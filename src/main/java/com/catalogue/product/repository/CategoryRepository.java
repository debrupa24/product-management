package com.catalogue.product.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.catalogue.product.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByCatagoryName(String name);
}
