package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.ShoppingCart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
@Transactional
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

    @PersistenceContext(name = "productDS")
    private EntityManager entityManager;

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<ShoppingCart> find(long id) {
        return Optional.empty();
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        entityManager.persist(shoppingCart);

        return shoppingCart;
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return null;
    }
}
