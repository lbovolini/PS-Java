package br.com.supera.game.store.api;

import br.com.supera.game.store.dto.ShoppingCartDTO;
import br.com.supera.game.store.service.ShoppingCartService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        shoppingCartService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ShoppingCartDTO> find(@PathVariable long id) {
        return shoppingCartService.find(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody ShoppingCartDTO shoppingCartDTO) {
        long shoppingCartId = shoppingCartService.save(shoppingCartDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(shoppingCartId + "/")
                .build()
                .toUri();

        return ResponseEntity.created(location).body(shoppingCartId);
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.update(shoppingCartDTO);

        return ResponseEntity.ok().build();
    }
}
