package br.com.tech4me.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.product.model.Product;
import br.com.tech4me.product.repository.Repository;
import br.com.tech4me.product.shared.ProductDto;
import br.com.tech4me.product.shared.ProductDtoCompleto;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Repository repositorio;



    @Override
    public ProductDtoCompleto cadastrarProdutos(ProductDtoCompleto dto) {
        Product produto = new Product (dto);
        repositorio.save(produto);
        return new ProductDtoCompleto(produto.getId(), 
        produto.getNome(),
        produto.getQuantidade(), 
        produto.getValor());
    }
    @Override
    public List<ProductDtoCompleto> obterProdutos() {
        return repositorio.findAll()
        .stream()
        .map(p -> new ProductDtoCompleto(p.getId(), p.getNome(), p.getQuantidade(), p.getValor()))
        .toList();
    }

    @Override
    public Optional<ProductDto> obterProdutoPorId(String id) {
       
    }

    @Override
    public void excluirProduto(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<ProductDto> atualizarPorId(String id, ProductDto dto) {
        Optional<Product> produto = repositorio.findById(id);
        
        if (produto.isPresent()) {
            Product produtoAtualizar = new Product(dto);
            produtoAtualizar.setId(id);
            repositorio.save(produtoAtualizar);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }
    
}
