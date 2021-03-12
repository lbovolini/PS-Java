package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Optional;

@Primary
public class CustomProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Collection<Product>> findAllByShoppingCartId(Long shoppingCartId) {
        Query query = entityManager.createQuery("SELECT p FROM Product p " +
                "JOIN CartProduct cp " +
                "ON p.id = cp.productId " +
                "WHERE cp.shoppingCartId = :shoppingCartId");
        query.setParameter("shoppingCartId", shoppingCartId);

        return Optional.ofNullable((Collection<Product>) query.getResultList());
    }
}
