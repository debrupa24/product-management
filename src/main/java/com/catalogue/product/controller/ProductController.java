package com.catalogue.product.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.product.model.Category;
import com.catalogue.product.model.Product;
import com.catalogue.product.model.SuccessMessage;
import com.catalogue.product.service.CategoryService;
import com.catalogue.product.service.ProductService;
import com.example.exception.CustomException;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/getProducts/{categoryName}")
	public Iterable<Product> getProducts(@Valid @PathVariable String categoryName) throws CustomException {
		try {
			Category categoryDB = categoryService.getCategoryByName(categoryName);
			if (categoryDB == null) {
				throw new CustomException("Category doesnor exist", HttpStatus.BAD_REQUEST);
			} else {
				return categoryDB.getProducts();
			}

		} catch (Exception e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getProduct/{productName}")
	public Product getProduct(String productName) throws CustomException {
		try {

			return productService.getProduct(productName);

		} catch (Exception e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateProduct")
	public SuccessMessage updateProduct(@Valid @RequestBody Product product) throws CustomException {
		try {

			String message = productService.updateProduct(product);

			return new SuccessMessage(message, HttpStatus.OK);
		} catch (CustomException e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateProducts")
	public SuccessMessage updateProducts(@Valid @RequestBody Set<Product> products) throws CustomException {
		try {

			String message = productService.updateProducts(products);

			return new SuccessMessage(message, HttpStatus.OK);
		} catch (CustomException e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteProduct/{id}")
	public SuccessMessage deleteCategory(@PathVariable Long id) throws CustomException {
		try {
			String message = productService.deleteProduct(id);
			return new SuccessMessage(message, HttpStatus.OK);
		} catch (Exception e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/addProduct/{categoryId}")
	public SuccessMessage addProduct(@PathVariable Long categoryId, @Valid @RequestBody Product product)
			throws CustomException {
		try {
			String message = productService.addProduct(categoryId, product);
			return new SuccessMessage(message, HttpStatus.OK);
		} catch (CustomException e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
