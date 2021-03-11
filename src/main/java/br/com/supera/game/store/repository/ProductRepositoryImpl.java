package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<Product> find(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Product> findAll() {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

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
