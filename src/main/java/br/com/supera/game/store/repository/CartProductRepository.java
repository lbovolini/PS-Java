package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends CustomCartProductRepository, JpaRepository<CartProduct, Long> {
}
