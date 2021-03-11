package br.com.supera.game.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotEmpty
    @OneToMany(mappedBy = "shoppingCart")
    @JoinColumn(name = "shopping_cart_id")
    private Collection<CartProduct> cartProducts = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Collection<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(Collection<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
