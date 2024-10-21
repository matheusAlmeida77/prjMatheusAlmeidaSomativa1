package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produto;
import com.example.demo.services.ProdutoService;

@RestController

//URL POSTMAN
@RequestMapping("/produtos")
public class ProdutoController {
	private final ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	//cria um novo produto
	@PostMapping
	public Produto createProduto(@RequestBody Produto produto) {
		return produtoService.saveProduto(produto);
	}
	
	//traz todos os registros de produtos
	@GetMapping
	public List<Produto> getAllProdutos(){
		return produtoService.getAllProdutos();
	}
	
	//traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Produto getProduto(@PathVariable Long id) {
		return produtoService.getProdutoById(id);
	}
	
	//deleta o objeto específico pelo id
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtoService.deleteProduto(id);
	}
	
	//endpoint de update
	@PutMapping("/{id}")
	public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
		return produtoService.updateProduto(id, produto);
	}
}
