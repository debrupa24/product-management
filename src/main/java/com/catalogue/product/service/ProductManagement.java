package com.catalogue.product.service;

import java.util.Set;

import com.catalogue.product.model.Category;
import com.catalogue.product.model.Product;
import com.example.exception.CustomException;

public interface ProductManagement {

	String addProduct(Long id, Product product) throws CustomException;

	String deleteProduct(Long id);

	Iterable<Product> getAllProducts(String categorName);

	Category getCategory(Product product);

	String updateProduct(Product product) throws CustomException;

	String updateProducts(Set<Product> products) throws CustomException;

	Product getProduct(String name);

}
