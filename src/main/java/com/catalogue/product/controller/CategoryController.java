package com.catalogue.product.controller;

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
import com.catalogue.product.model.SuccessMessage;
import com.catalogue.product.service.CategoryService;
import com.example.exception.CustomException;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/getCategories")
	public Iterable<Category> getCategory() throws CustomException {
		try {
			return categoryService.getCategories();

		} catch (Exception e) {

			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/addCategory")
	public SuccessMessage addCategory(@Valid @RequestBody Category category) throws CustomException {
		try {
			String message = categoryService.addCategory(category);
			return new SuccessMessage(message, HttpStatus.OK);
		} catch (Exception e) {

			return new SuccessMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateCategory")
	public SuccessMessage updateCategory(@Valid @RequestBody Category category) throws CustomException {
		try {
			
			String message = categoryService.updateCategory(category);
		
			return new SuccessMessage(message, HttpStatus.OK);
		} catch (Exception e) {
			return new SuccessMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteCategory/{id}")
	public SuccessMessage deleteCategory(@PathVariable Long id) throws CustomException {
		try {
			String message = categoryService.deleteCategory(id);
			return new SuccessMessage(message, HttpStatus.OK);
		} catch (Exception e) {
			return new SuccessMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
