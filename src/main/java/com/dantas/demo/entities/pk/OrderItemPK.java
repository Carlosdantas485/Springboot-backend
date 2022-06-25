//esta classe se referencia a duas classes "pedido" e "produto"
package com.dantas.demo.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dantas.demo.entities.Order;
import com.dantas.demo.entities.Product;

//neste caso que é uma classe de chaveprimaria composta. usar a anotation @Embeddable ao envez de @Entity
@Embeddable
public class OrderItemPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//tipo de ralcao no banco de dados
	@ManyToOne
	//nome da chave estrangeira 
	@JoinColumn(name = "order_id")
	private Order order;
	
	//tipo de ralcao no banco de dados
	@ManyToOne
	//nome da chave estrangeira 
	@JoinColumn(name = "product_id")
	private Product product;
	
	
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
	
	// neste caso quando for gerar os hashcode e equals. sera necessario comparar tanto o pedido quanto o produto 
	
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
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	

}
