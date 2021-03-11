package br.com.supera.game.store.repository;

import br.com.supera.game.store.dto.ShoppingCartDTO;
import br.com.supera.game.store.model.CartProduct;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import com.github.lbovolini.mapper.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Transactional
public class CustomShoppingCartRepositoryImpl implements CustomShoppingCartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<ShoppingCart> find(long id) {
        return Optional.empty();
    }

    @Override
    public ShoppingCart save(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = ObjectMapper.map(shoppingCartDTO, ShoppingCart.class);

        final ShoppingCart savedShoppingCart = entityManager.merge(shoppingCart);

        Collection<Product> productCollection = ObjectMapper.map(shoppingCartDTO.getProductDTOCollection(), ArrayList.class);

        Collection<CartProduct> cartProductCollection = productCollection.stream().map(product -> {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setShoppingCartId(savedShoppingCart.getId());
            cartProduct.setProductId(product.getId());

            return cartProduct;
        }).collect(Collectors.toList());

        for (CartProduct cartProduct : cartProductCollection) {
            entityManager.merge(cartProduct);
        }

        return savedShoppingCart;
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return null;
    }
}
