package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.ShoppingCart;

import java.util.Optional;

public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<ShoppingCart> find(long id) {
        return Optional.empty();
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return null;
    }
}
