package com.example.webflux.handler;

import com.example.webflux.domain.User;
import com.example.webflux.domain.UserKey;
import com.example.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);

        return userMono.flatMap(user ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(this.userRepository.save(user), User.class));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);

        return userMono.flatMap(user ->
                ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(this.userRepository.save(user), User.class));
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String cpf = request.pathVariable("cpf");

        Mono<User> userMono = this.userRepository.findById(new UserKey(cpf));
        Mono<ServerResponse> dataNotFound = ServerResponse.notFound().build();

        return userMono
                .flatMap(user ->
                        ServerResponse.ok()
                                .contentType(APPLICATION_JSON)
                                .body(fromObject(user)))
                .switchIfEmpty(dataNotFound);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<User> users = this.userRepository.findAll();

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(users, User.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        String cpf = request.pathVariable("cpf");

        Mono<User> userMono = this.userRepository.findById(new UserKey(cpf));
        Mono<ServerResponse> dataNotFound = ServerResponse.notFound().build();

        return userMono
                .flatMap(existingUser ->
                        ServerResponse.ok()
                                .build(this.userRepository.delete(existingUser))
                )
                .switchIfEmpty(dataNotFound);
    }
}
