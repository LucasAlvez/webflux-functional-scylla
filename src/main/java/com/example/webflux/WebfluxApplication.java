package com.example.webflux;

import com.example.webflux.handler.UserHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class WebfluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routes(UserHandler handler) {
        return nest(path("/"),
                nest(accept(APPLICATION_JSON).or(contentType(APPLICATION_JSON)).or(accept(TEXT_EVENT_STREAM)),
                        route(method(HttpMethod.GET), handler::findAll)
                                .andRoute(method(HttpMethod.POST), handler::save)
                                .andRoute(method(HttpMethod.PUT), handler::update)

                                .andNest(path("/{cpf}"),
                                        route(method(HttpMethod.GET), handler::findById)
                                                .andRoute(method(HttpMethod.DELETE), handler::delete)
                                )
                )
        );
    }

}
