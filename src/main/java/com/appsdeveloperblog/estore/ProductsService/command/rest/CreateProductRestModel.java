package com.appsdeveloperblog.estore.ProductsService.command.rest;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateProductRestModel { 
	
//	@NotBlank(message = "Product Title is a required Field")
	private String title;
	
	@Min(value = 1, message = "Value should be greater than 0")
	private BigDecimal price;

	@Min(value = 1, message = "Quantity should be greater than 0")
	private Integer quantity;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
