package br.com.tech4me.product.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.product.shared.ProductDto;
import br.com.tech4me.product.shared.ProductDtoCompleto;

public interface ProductService {
    ProductDtoCompleto cadastrarProdutos(ProductDtoCompleto dto);
    List<ProductDtoCompleto> obterProdutos();
    Optional<ProductDto> obterProdutoPorId(String id);
    void excluirProduto(String id);
    Optional<ProductDto> atualizarPorId(String id, ProductDto dto);
}
