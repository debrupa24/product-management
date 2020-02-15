package com.catalogue.product.model;

import javax.persistence.Embeddable;

@Embeddable
public class UpdateHistory {
	
	private String updatedBy;
	private String updateComment;
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdateComment() {
		return updateComment;
	}
	public void setUpdateComment(String updateComment) {
		this.updateComment = updateComment;
	}
	
	public UpdateHistory(String updatedBy, String updateComment) {
		super();
		this.updatedBy = updatedBy;
		this.updateComment = updateComment;
	}
	public UpdateHistory() {
		super();
		
	}
	
	
	

}
