package br.com.supera.game.store.service;

import br.com.supera.game.store.dto.ShoppingCartDTO;
import br.com.supera.game.store.model.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService {

    Optional<ShoppingCart> find(long id);

    void delete(long id);

    long save(ShoppingCartDTO shoppingCartDTO);

    void update(ShoppingCart shoppingCart);
}
