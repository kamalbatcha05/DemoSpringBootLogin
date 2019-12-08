package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import com.example.demo.utils.JsonObjectSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product {

	private static final String NOT_BLANK_MESSAGE = "The value may not be empty!";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;

	@NotBlank(message = NOT_BLANK_MESSAGE)
	@Column(name = "product_name")
	@Size(max = 25)
	private String productName;

	@Column(name = "status")
	@Size(max = 25)
	private String status;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@JsonSerialize(using = JsonObjectSerializer.class)
	@NotNull(message = "Category should not be empty!")
	private Category category;

	@CreationTimestamp
	@Column(name = "created_date")
    private Date createdDateTime;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private Date updatedDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
 
    public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
