package br.com.supera.game.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private long id;

    private long userId;

    private Collection<Product> products;
}
