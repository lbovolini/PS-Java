package br.com.supera.game.store.api;

import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.CustomShoppingCartRepository;
import br.com.supera.game.store.repository.CustomShoppingCartRepositoryImpl;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import br.com.supera.game.store.service.ShoppingCartServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingCartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void shouldSaveUserWithCreatedStatus() throws Exception {

        ShoppingCart shoppingCart = new ShoppingCart();

        mockMvc.perform(post("/api/v1/carts")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(shoppingCart)))
                .andExpect(status().isCreated());

    }
}