package br.com.supera.game.store.repository;

public interface CustomCartProductRepository {

    void deleteAllByShoppingCartId(long cartId);
}
