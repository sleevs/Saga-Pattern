package br.com.jsnsoftware.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("ORDER API")
                        .description("SAGA PATTERN DISTRIBUTED TRANSACTION WITJ MESSAGE BROKER CHOREOGRAPHY")
                        .termsOfService("terms")
                        .contact(new Contact().email("@jsnsoftware.dev"))
                        .license(new License().name("GNU"))
                        .version("1.0")
                );

    }
}
