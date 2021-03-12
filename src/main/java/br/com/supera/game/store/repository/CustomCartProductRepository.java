package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;

import java.util.Collection;

public interface CustomCartProductRepository {

    void deleteAllByShoppingCartId(long cartId);

    void updateAll(Long shoppingCartId, Collection<Product> products);
}
