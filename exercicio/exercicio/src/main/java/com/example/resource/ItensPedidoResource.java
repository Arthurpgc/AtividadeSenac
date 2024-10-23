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
import com.example.model.ItensPedido;
import com.example.repository.ItensPedidoRepository;
import jakarta.servlet.http.HttpServletResponse;

public class ItensPedidoResource {
	
	@Autowired
	private ItensPedidoRepository itensRepository;
	
	@GetMapping
	public List<ItensPedido> list() {
		return itensRepository.findAll();
	}

	@GetMapping
	public Optional<ItensPedido> findById(@PathVariable Long id) {
		return itensRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<ItensPedido> create(@RequestBody ItensPedido itensPedido, HttpServletResponse response){
		ItensPedido save = itensRepository.save(itensPedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(uri).body(save);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		itensRepository.deleteById(id); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItensPedido> update(@PathVariable Long id,
			@RequestBody ItensPedido itensPedido) {
		Optional<ItensPedido> itensPedidoBanco = itensRepository.findById(id);
		BeanUtils.copyProperties(itensPedido, itensPedidoBanco.get(), "id");
		itensRepository.save(itensPedidoBanco.get());
		return ResponseEntity.ok(itensPedido);
	}
	
}
