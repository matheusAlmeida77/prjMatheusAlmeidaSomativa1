package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	//criação do produto
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//buscar produto
	public Produto getProdutoById(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	//procurar todos os produtos
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}	
	
	//excluir os produtos
	public void deleteProduto(Long id) {
		produtoRepository.deleteById(id);
	}
	
	//atualizar produto
		public Produto updateProduto(Long id, Produto updatedProduto) {
			//criando o optional para receber o produto
			Optional<Produto> optionalProduto = produtoRepository.findById(id);
			if (optionalProduto.isPresent()) {
				//se encontrou
				Produto existentProduto = optionalProduto.get();
				existentProduto.setNome(updatedProduto.getNome());
				existentProduto.setQuantidadeEmEstoque(updatedProduto.getQuantidadeEmEstoque());
				existentProduto.setPreco(updatedProduto.getPreco());
				return produtoRepository.save(existentProduto); 
			}else {
				//se não encontrou
				return null;
			}
		}
}
