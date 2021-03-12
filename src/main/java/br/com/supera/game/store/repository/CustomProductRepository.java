package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface CustomProductRepository {
    Optional<Collection<Product>> findAllByShoppingCartId(Long id);

}
