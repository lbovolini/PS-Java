package br.com.supera.game.store.api;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/v1/products",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> find(@PathVariable long id) {
        return productService.find(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody Product product) {
        long productId = productService.save(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(productId + "/")
                .build()
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody Product product) {
        productService.update(product);

        return ResponseEntity.ok().build();
    }
}
