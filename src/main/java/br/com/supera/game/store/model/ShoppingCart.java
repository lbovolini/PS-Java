package br.com.supera.game.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "product")
    private Collection<CartProduct> cartProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
