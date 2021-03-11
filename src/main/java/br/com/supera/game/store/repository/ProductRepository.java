package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    void delete(long id);

    Optional<Product> find(long id);

    Collection<Product> findAll();

    Product save(Product product);

    Product update(Product product);

    Optional<Collection<Product>> findAllByShoppingCartId(Long id);
}
