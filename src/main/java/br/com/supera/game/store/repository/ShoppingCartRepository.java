package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartRepository {

    void delete(long id);

    Optional<ShoppingCart> find(long id);

    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart update(ShoppingCart shoppingCart);

}
