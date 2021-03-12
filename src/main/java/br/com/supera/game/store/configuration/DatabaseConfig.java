package br.com.supera.game.store.configuration;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.context.annotation.*;

@Configuration
public class DatabaseConfig {

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new SnakeCasePhysicalNamingStrategy();
    }

}