package com.catalogue.product.service;

import java.util.Set;

import com.catalogue.product.model.Category;
import com.example.exception.CustomException;

public interface CategoryManagement {
	
	String addCategory(Category category) throws CustomException;
	String updateCategory(Category category) throws CustomException;
	Iterable<Category> getCategories();
	Category getCategoryByName(String name );
	String deleteCategory(Long id ) throws CustomException;
	
	

}
