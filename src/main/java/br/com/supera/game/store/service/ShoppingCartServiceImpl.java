package br.com.supera.game.store.service;

import br.com.supera.game.store.dto.ShoppingCartDTO;
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
        return shoppingCartRepository.find(id);
    }

    @Override
    public void delete(long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public long save(ShoppingCartDTO shoppingCartDTO) {
        return shoppingCartRepository.save(shoppingCartDTO).getId();
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        shoppingCartRepository.update(shoppingCart);
    }
}
