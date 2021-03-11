package br.com.supera.game.store.dto;

import java.util.Collection;

public class ShoppingCartDTO {

    private long id;

    private long userId;

    private Collection<ProductDTO> productDTOCollection;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Collection<ProductDTO> getProductDTOCollection() {
        return productDTOCollection;
    }

    public void setProductDTOCollection(Collection<ProductDTO> productDTOCollection) {
        this.productDTOCollection = productDTOCollection;
    }
}
