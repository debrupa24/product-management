package com.catalogue.product.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	

	@NotNull
	private String productName;
	
	private String productDescription;

	private Date createdAt;
	
	private String createdBy;
	
	private Date updatedAt;
	
	private BigDecimal price;
	
	private String currencyType;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	@JsonIgnore
	private Category category;
	
	@Embedded
	private UpdateHistory updateHistory;
	
	
	@PrePersist
	public void setCreatedAt() {
		this.createdAt= new Date();
	}
	
	
	public Long getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public UpdateHistory getUpdateHistory() {
		return updateHistory;
	}

	public void setUpdateHistory(UpdateHistory updateHistory) {
		this.updateHistory = updateHistory;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getCurrencyType() {
		return currencyType;
	}


	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}



	
	
	

}
