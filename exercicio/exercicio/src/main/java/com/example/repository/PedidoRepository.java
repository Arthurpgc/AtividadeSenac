package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
