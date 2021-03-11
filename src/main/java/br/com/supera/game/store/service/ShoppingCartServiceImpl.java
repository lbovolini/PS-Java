package br.com.supera.game.store.service;

import br.com.supera.game.store.dto.ShoppingCartDTO;
import br.com.supera.game.store.model.CartProduct;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.CartProductRepository;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import com.github.lbovolini.mapper.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final CartProductRepository cartProductRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   CartProductRepository cartProductRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public Optional<ShoppingCartDTO> find(long id) {
        return shoppingCartRepository.findById(id)
                .map(shoppingCart -> ObjectMapper.map(shoppingCart, ShoppingCartDTO.class));
    }

    @Override
    public void delete(long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Transactional
    @Override
    public long save(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = ObjectMapper.map(shoppingCartDTO, ShoppingCart.class);
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);

        final long shoppingCartId = savedShoppingCart.getId();

        Collection<Product> productCollection = ObjectMapper.map(shoppingCartDTO.getProducts(), Product.class);

        Collection<CartProduct> cartProductCollection = productCollection.stream()
                .map(product -> new CartProduct(shoppingCartId, product.getId()))
                .collect(Collectors.toUnmodifiableList());

        cartProductRepository.saveAll(cartProductCollection);

        return shoppingCartId;
    }

    @Override
    public void update(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = ObjectMapper.map(shoppingCartDTO, ShoppingCart.class);
        shoppingCartRepository.save(shoppingCart);
    }
}
