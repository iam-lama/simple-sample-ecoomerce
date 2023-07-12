package com.ecommerce.learn.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")

public class OrderProductPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

	
    
    public OrderProductPK() {
		super();
	}
   
    
	public OrderProductPK(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductPK other = (OrderProductPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
    
	
    

}
