package com.dantas.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dantas.demo.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	// como é um id composto utiliza-se o @EmbeddedId
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	private Integer quantity;
	private Double price;

	public OrderItem() {

	}

	// nao colocar o id
	// e adicionar o Order order, Product product
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();

		// pegar o id do produto e da ordem
		id.setOrder(order);
		id.setProduct(product);

		this.quantity = quantity;
		this.price = price;
	}

	// Corta o loop
	@JsonIgnore
	// criar o get da order
	public Order getOrder() {
		return id.getOrder();
	}

	// criar o set da order
	public void setOrder(Order order) {
		id.setOrder(order);
	}

	
	// criar o get da Product
	public Product getProduct() {
		return id.getProduct();
	}

	// criar o set da order
	public void setProductr(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// no caso do hashcode e equals colocar apenas o ID
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

}
