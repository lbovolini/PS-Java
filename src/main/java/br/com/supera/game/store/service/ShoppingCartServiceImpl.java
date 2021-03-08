package br.com.supera.game.store.service;

import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public Optional<ShoppingCart> find(long id) {
        return Optional.empty();
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long save(ShoppingCart shoppingCart) {
        return 0;
    }

    @Override
    public void update(ShoppingCart shoppingCart) {

    }
}
