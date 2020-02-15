package com.catalogue.product.service;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.catalogue.product.model.Category;
import com.catalogue.product.model.Product;
import com.catalogue.product.model.UpdateHistory;
import com.catalogue.product.repository.CategoryRepository;
import com.example.exception.CustomException;

@Service
public class CategoryService implements CategoryManagement {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductService productService;

	@Override
	public String addCategory(Category category) throws CustomException {

		Category categoryDB = categoryRepository.findByCatagoryName(category.getCatagoryName());

		if (categoryDB == null) {
			Set<Product> products = category.getProducts();

			products.stream().forEach(x -> x.setCategory(category));

			categoryRepository.save(category);
			return "success";
		} else {
			throw new CustomException("Category already exist,Try updating", HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public String updateCategory(Category category) throws CustomException {
		try {
			
			System.out.println("id :"+category.getCategoryId());
			Category categorydb = categoryRepository.findById(category.getCategoryId()).get();
			if (categorydb == null) {
				throw new CustomException("Category doesn't exist,Try adding", HttpStatus.BAD_REQUEST);
			} else {

				categorydb.setCatagoryDescription(category.getCatagoryDescription());
				categorydb.setCatagoryName(category.getCatagoryName());
				categorydb.setUpdateHistory(category.getUpdateHistory());
				categoryRepository.save(categorydb);
				Set<Product> products = category.getProducts();
				
				return productService.updateProducts(products, category.getCategoryId());
				

			}
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		

		

	}

	@Override
	public Iterable<Category> getCategories() {

		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryByName(String name) {

		return categoryRepository.findByCatagoryName(name);
	}

	@Override
	public String deleteCategory(Long id ) throws CustomException {
		try {
			categoryRepository.deleteById(id);
			return "success";
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
