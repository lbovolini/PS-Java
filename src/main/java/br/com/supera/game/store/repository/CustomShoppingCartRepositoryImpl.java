package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomShoppingCartRepositoryImpl implements CustomShoppingCartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void update(ShoppingCart shoppingCart) {
        entityManager.merge(shoppingCart);
    }
}
