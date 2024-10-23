package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "produto")
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private long id;
	
	@Column(name = "des_pro")
	private long desPro;
	
	@Column(name = "quan_produto")
	private int qtdeProduto;
	
	@Column(name = "val_produto")
	private double valProduto;

	public long getDesPro() {
		return desPro;
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setDesPro(long desPro) {
		this.desPro = desPro;
	}

	public int getQtdeProduto() {
		return qtdeProduto;
	}

	public void setQtdeProduto(int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}

	public double getValProduto() {
		return valProduto;
	}

	public void setValProduto(double valProduto) {
		this.valProduto = valProduto;
	} 

}
