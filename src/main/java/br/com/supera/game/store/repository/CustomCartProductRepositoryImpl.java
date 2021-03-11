package br.com.supera.game.store.repository;

import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Primary
public class CustomCartProductRepositoryImpl implements CustomCartProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteAllByShoppingCartId(long shoppingCartId) {
        Query query = entityManager.createQuery("DELETE FROM CartProduct WHERE shoppingCartId = :shoppingCartId");
        query.setParameter("shoppingCartId", shoppingCartId);
        query.executeUpdate();
    }
}
