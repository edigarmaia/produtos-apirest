package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos do banco de dados")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto único do banco de dados")
	public Produto listaProdutoPorId(@PathVariable(value = "id") long id) {
	return produtoRepository.findById(id);
	}
	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto no banco de dados")
	public Produto incluirProduto(@RequestBody Produto produto) {
	return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto do banco de dados")
	public void deletarProduto(@RequestBody Produto produto) {
	produtoRepository.delete(produto);
	}
		
	@PutMapping("/produto")
	@ApiOperation(value="Altera/atualiza um produto no banco de dados")
	public Produto atualizarProduto(@RequestBody Produto produto) {
	return produtoRepository.save(produto);
	}
	
}
