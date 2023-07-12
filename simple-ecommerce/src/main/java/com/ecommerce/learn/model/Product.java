package com.ecommerce.learn.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	@NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;
    private Double price;
    private String pictureUrl;
	
    public Product() {
		super();
	}
	public Product(long id, @NotNull(message = "Product name is required.") String name, Double price,
			String pictureUrl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pictureUrl = pictureUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
    

}
