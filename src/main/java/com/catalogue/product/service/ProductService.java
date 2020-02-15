package com.catalogue.product.service;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.catalogue.product.model.Category;
import com.catalogue.product.model.Product;
import com.catalogue.product.model.UpdateHistory;
import com.catalogue.product.repository.CategoryRepository;
import com.catalogue.product.repository.ProductRepository;
import com.example.exception.CustomException;

@Service
public class ProductService implements ProductManagement {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public String addProduct(Long id,Product product) throws CustomException {
		try {
			
			Category categorydb = categoryRepository.findById(id).get();
			
			if(categorydb == null) {
				throw new CustomException("Category for the product not found", HttpStatus.BAD_REQUEST);
			}else {
				product.setCategory(categorydb);
				Set<Product> products = categorydb.getProducts();
				products.add(product);
				categoryRepository.save(categorydb);
				return "success";
				
			}
			
			
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		

	}

	@Override
	public String updateProduct(Product product) throws CustomException {
		
		try {
			Product productdb = productRepository.findById(product.getProductId()).get();
			
			if(productdb == null) {
				productRepository.save(product);
				return "success";
			}else {
				productdb.setProductDescription(product.getProductDescription());
				productdb.setCurrencyType(product.getCurrencyType());
				productdb.setPrice(product.getPrice());
				productdb.setProductName(product.getProductName());
				productdb.setUpdateHistory(product.getUpdateHistory());
				productRepository.save(productdb);
				return "success";
				
			}
			
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
		
		
		 
	}

	@Override
	public String deleteProduct(Long id) {
		try {
			productRepository.deleteById(id);
			return "success";
		}catch(Exception e) {
			throw e;
		}
		
		

	}

	@Override
	public Iterable<Product> getAllProducts(String categorName) {
		 return productRepository.findBycategory(categoryRepository.findByCatagoryName(categorName));

	}

	@Override
	public Category getCategory(Product product) {
		return categoryRepository.findById(product.getCategory().getCategoryId()).get();
	}

	@Override
	public Product getProduct(String name) {
		return productRepository.findByProductName(name);
	}

	@Override
	public String updateProducts(Set<Product> products, Long id) throws CustomException {
		Product product;
		
		
			Iterator<Product> it = products.iterator();
			while(it.hasNext()){
		    	updateProduct(it.next());
		     }
			return "success";
		
	     
	
		
		
	}

}
