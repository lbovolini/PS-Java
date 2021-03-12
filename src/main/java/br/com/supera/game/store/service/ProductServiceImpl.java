package br.com.supera.game.store.service;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> find(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Long save(Product product) {
        return productRepository.save(product).getId();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }
}
