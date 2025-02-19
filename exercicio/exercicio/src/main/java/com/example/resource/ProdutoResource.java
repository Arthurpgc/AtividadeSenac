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
import com.example.model.Produto;
import com.example.repository.ProdutoRepository;

import jakarta.servlet.http.HttpServletResponse;

public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> list() {
		return produtoRepository.findAll();
		
	}
	
	public Optional<Produto> findByOptional(@PathVariable Long id) {
		return produtoRepository.findById(id);
	
	}

	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto, HttpServletResponse response){
		Produto save = produtoRepository.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(uri).body(save);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produtoRepository.deleteById(id); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id,
			@RequestBody Produto produto) {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		BeanUtils.copyProperties(produto, produtoBanco.get(), "id");
		produtoRepository.save(produtoBanco.get());
		return ResponseEntity.ok(produto);
	}
	
 }
	

