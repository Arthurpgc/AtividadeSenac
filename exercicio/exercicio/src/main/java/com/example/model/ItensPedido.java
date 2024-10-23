package com.example.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itens_id")
	private Long id;
	
	@Column(name = "qtd_item")
	private Double qtdeItem; 
	
	@Column(name = "val_unitario")
	private Double valProduto;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQtdeItem() {
		return qtdeItem;
	}

	public void setQtdeItem(Double qtdeItem) {
		this.qtdeItem = qtdeItem;
	}

	public Double getValProduto() {
		return valProduto;
	}

	public void setValProduto(Double valProduto) {
		this.valProduto = valProduto;
	}
	
	

}
