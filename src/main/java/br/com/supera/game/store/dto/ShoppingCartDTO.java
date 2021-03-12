package br.com.supera.game.store.dto;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public class ShoppingCartDTO {

    private Long id;

    @NotNull
    private Long userId;

    private Collection<ProductDTO> products;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Collection<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductDTO> products) {
        this.products = products;
    }
}
