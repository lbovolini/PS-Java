package br.com.supera.game.store.service;

import br.com.supera.game.store.dto.ShoppingCartDTO;

import java.util.Optional;

public interface ShoppingCartService {

    Optional<ShoppingCartDTO> find(long id);

    void delete(long id);

    long save(ShoppingCartDTO shoppingCartDTO);

    void update(ShoppingCartDTO shoppingCartDTO);
}
