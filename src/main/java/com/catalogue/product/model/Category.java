package com.catalogue.product.model;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@NotNull(message = "The catagoryName name must not be null")
	@NotBlank(message = "The catagoryName name must not be blank")
	@Column(unique=true)
	private String catagoryName;
	
	private String catagoryDescription;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)	
	private Set<Product> products;
	
	private Date createdAt;
	
	private String createdBy;
	
	public Long getCategoryId() {
		return categoryId;
	}

	

	@PrePersist
	public void setCreatedAt() {
		this.createdAt= new Date();
	}
	
	@Embedded
	private UpdateHistory updateHistory;
	
	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public String getCatagoryDescription() {
		return catagoryDescription;
	}

	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public UpdateHistory getUpdateHistory() {
		return updateHistory;
	}

	public void setUpdateHistory(UpdateHistory updateHistory) {
		this.updateHistory = updateHistory;
	}



	

	
	
	

}
