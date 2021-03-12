package br.com.supera.game.store.service;

import br.com.supera.game.store.model.Product;

import java.util.Optional;

public interface ProductService {
    void delete(long id);

    Optional<Product> find(long id);

    Long save(Product product);

    void update(Product product);
}
