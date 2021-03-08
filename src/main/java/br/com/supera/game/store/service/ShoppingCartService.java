package br.com.supera.game.store.service;

import br.com.supera.game.store.model.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService {

    Optional<ShoppingCart> find(long id);

    void delete(long id);

    long save(ShoppingCart shoppingCart);

    void update(ShoppingCart shoppingCart);
}
