package com.ecommerce.learn.controllert;

import java.util.List;
import java.util.ArrayList;

import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.ecommerce.learn.dto.OrderProductDto;
import com.ecommerce.learn.model.Order;
import com.ecommerce.learn.model.OrderProduct;
import com.ecommerce.learn.model.OrderStatus;
import com.ecommerce.learn.service.OrderProductService;
import com.ecommerce.learn.service.OrderService;
import com.ecommerce.learn.service.ProductService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/orders")

public class OrderController {
	
	private ProductService productService;
    private OrderService orderService;
    private OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService, 
    		OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }
    
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody OrderForm form) {
		List<OrderProductDto> formDtos = form.getProductOrders();

        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
              .getProduct()
              .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(order.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}
	
	
	private void validateProductsExistence(List<OrderProductDto> orderProducts) {
		 List<OrderProductDto> list = orderProducts
				.stream()
				.filter(ob -> Objects.isNull(productService.getProduct(ob.getProduct().getId())))
				.collect(Collectors.toList());
		 if (!CollectionUtils.isEmpty(list)) {
			 new InvalidConfigurationPropertyValueException(null, null,"Product not found!");
			 
		 }		 
	}
	public static class OrderForm {

        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }

	
	public class ResponseTransfer {
	    private String text;
	    
	    

		public ResponseTransfer(String text) {
			super();
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		} 
	   	    
	}

}
