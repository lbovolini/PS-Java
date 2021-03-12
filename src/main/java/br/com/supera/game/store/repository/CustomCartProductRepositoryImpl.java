package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.CartProduct;
import br.com.supera.game.store.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public void updateAll(Long shoppingCartId, Collection<Product> products) {

        if (Objects.isNull(shoppingCartId)) {
            return;
        }

        List<Long> productIds = Objects.isNull(products)
                ? List.of()
                : products.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());

        Query deleteQuery = entityManager.createQuery("DELETE FROM CartProduct WHERE shoppingCartId = :shoppingCartId");
        //deleteQuery.setParameter("productIds", productIds);
        deleteQuery.setParameter("shoppingCartId", shoppingCartId);

        deleteQuery.executeUpdate();

        for (Product product : products) {
            entityManager.merge(new CartProduct(shoppingCartId, product.getId()));
        }
    }
}
