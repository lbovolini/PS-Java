package br.com.supera.game.store.api;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.service.ShoppingCartService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/v1/carts",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public ResponseEntity delete(long id) {

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity find(long id) {

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Product product) {

        String path = "";

        return ResponseEntity.created(URI.create(path)).build();
    }


    public ResponseEntity update(ShoppingCart shoppingCart) {

        return ResponseEntity.ok().build();
    }
}
