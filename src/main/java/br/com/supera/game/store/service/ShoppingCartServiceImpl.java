package br.com.supera.game.store.service;

import br.com.supera.game.store.dto.ProductDTO;
import br.com.supera.game.store.dto.ShoppingCartDTO;
import br.com.supera.game.store.model.CartProduct;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.CartProductRepository;
import br.com.supera.game.store.repository.ProductRepository;
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
    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   CartProductRepository cartProductRepository,
                                   ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Optional<ShoppingCartDTO> find(long id) {

        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);

        Optional<Collection<ProductDTO>> productDTOsOptional = shoppingCartOptional
                .flatMap(shoppingCart -> {
                    Optional<Collection<Product>> optionalProducts = productRepository.findAllByShoppingCartId(shoppingCart.getId());
                    return optionalProducts.flatMap(products -> Optional.ofNullable(ObjectMapper.map(products, ProductDTO.class)));
                });

        return shoppingCartOptional.map(shoppingCart -> {
            ShoppingCartDTO shoppingCartDTO = ObjectMapper.map(shoppingCart, ShoppingCartDTO.class);
            productDTOsOptional.ifPresent(shoppingCartDTO::setProducts);
            return shoppingCartDTO;
        });
    }

    @Transactional
    @Override
    public void delete(long id) {
        cartProductRepository.deleteAllByShoppingCartId(id);
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

    @Transactional
    @Override
    public void update(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = ObjectMapper.map(shoppingCartDTO, ShoppingCart.class);
        Collection<Product> products = ObjectMapper.map(shoppingCartDTO.getProducts(), Product.class);
        shoppingCartRepository.update(shoppingCart);
        cartProductRepository.updateAll(shoppingCartDTO.getId(), products);
    }
}
