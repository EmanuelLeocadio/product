package br.com.tech4me.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.product.model.Product;

public interface Repository extends MongoRepository<Product, String> {
    
}
