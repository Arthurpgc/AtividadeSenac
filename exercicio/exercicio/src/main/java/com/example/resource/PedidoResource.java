package com.example.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.model.Pedido;
import com.example.repository.PedidoRepository;

import jakarta.servlet.http.HttpServletResponse;

public class PedidoResource {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<Pedido> list() {
		return pedidoRepository.findAll();
		
	}
	
	public Optional<Pedido> findByOptional(@PathVariable Long id) {
		return pedidoRepository.findById(id);
	
	}

	
	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido, HttpServletResponse response){
		Pedido save = pedidoRepository.save(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(uri).body(save);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pedidoRepository.deleteById(id); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Long id,
			@RequestBody Pedido pedido) {
		Optional<Pedido> pedidoBanco = pedidoRepository.findById(id);
		BeanUtils.copyProperties(pedido, pedidoBanco.get(), "id");
		pedidoRepository.save(pedidoBanco.get());
		return ResponseEntity.ok(pedido);
	}
	
 }



