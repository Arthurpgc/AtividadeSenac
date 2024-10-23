package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pedido_id")
	private long id; 
	
	@Column(name = "nro_pedido")
	private long nroPedido;
	
	@Column(name = "date_pedido")
	private LocalDate datPedido;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(long nroPedido) {
		this.nroPedido = nroPedido;
	}

	public LocalDate getDatPedido() {
		return datPedido;
	}

	public void setDatPedido(LocalDate datPedido) {
		this.datPedido = datPedido;
	}
	
	
}
