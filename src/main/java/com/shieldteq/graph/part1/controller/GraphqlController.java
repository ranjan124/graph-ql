package com.shieldteq.graph.part1.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GraphqlController {
    @QueryMapping(name = "sayHello")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World!");
    }

    @QueryMapping
    public Mono<String> sayHelloTo(@Argument String name) {
        return Mono.fromSupplier(() -> "Hello " + name + "!");
    }
    @QueryMapping
    public Mono<Integer> random() {
        return Mono.fromSupplier(() -> ThreadLocalRandom.current().nextInt(0, 1000));
    }
}
