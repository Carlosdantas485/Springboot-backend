package com.dantas.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	// transforma essas colecoes em uma tabela de asociacao
	@ManyToMany
	// chase estrangeira que vao se relacionar
	@JoinTable(
			// nome da tabela de asociacao
			name = "tb_product_category",
			// chave estrangeira referenta a abela daentidade do produto
			joinColumns = @JoinColumn(name = "product_id"),
			// chave estrangeira da entidade categoria categoria
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	// nome/colecao de categorias
	private Set<Category> categosires = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	// nome/colecao de OrderItem
	private Set<OrderItem> items = new HashSet<>();

	public Product() {

	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategosires() {
		return categosires;
	}

	// Corta o loop
	@JsonIgnore
	// realciona cada orderItem com sua order
	public Set<Order> getOrders() {
		Set<Order> set = new HashSet<>();
		// para cada ( OrderItem pedido1 cntido na lista de items)
		for (OrderItem x : items) {
			set.add(x.getOrder());
		}

		return set;
	}

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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
