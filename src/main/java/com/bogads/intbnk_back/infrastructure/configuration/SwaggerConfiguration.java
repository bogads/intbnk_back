package com.bogads.intbnk_back.infrastructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Interbanking exercise")
                        .description("Interbanking exercise")
                        .version("1.0")
                        .contact(new Contact().email("seebogado@gmail.com")
                                .name("Sebastian Bogado")
                                .url("https://github.com/bogads")
                        )
                )
                .servers(List.of(new Server().url("/")));
    }

}
