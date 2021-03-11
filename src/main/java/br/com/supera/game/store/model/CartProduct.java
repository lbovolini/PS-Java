package br.com.supera.game.store.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", insertable = false, updatable = false)
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @NotNull
    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;

    @NotNull
    @Column(name = "product_id")
    private Long productId;

    public CartProduct() {
    }

    public CartProduct(Long shoppingCartId, Long productId) {
        this.id = 0L;
        this.shoppingCartId = shoppingCartId;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
