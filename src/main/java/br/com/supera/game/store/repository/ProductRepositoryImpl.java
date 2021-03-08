package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

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
}
