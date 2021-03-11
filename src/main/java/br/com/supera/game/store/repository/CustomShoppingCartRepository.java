package br.com.supera.game.store.repository;

import br.com.supera.game.store.dto.ShoppingCartDTO;
import br.com.supera.game.store.model.ShoppingCart;

import java.util.Optional;

public interface CustomShoppingCartRepository {

    void delete(long id);

    Optional<ShoppingCart> find(long id);

    ShoppingCart save(ShoppingCartDTO shoppingCartDTO);

    ShoppingCart update(ShoppingCart shoppingCart);

}
