package com.shieldteq.graph.part7.service;

import com.shieldteq.graph.part7.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private static final Flux<Customer> customers = Flux.just(
            new Customer(1, "John", 30, "London"),
            new Customer(2, "Jane", 25, "New York"),
            new Customer(3, "Mike", 40, "Paris")
    );

    public Flux<Customer> getCustomers() {
        return customers.delayElements(java.time.Duration.ofSeconds(1)).doOnNext(c -> printMsg("Customer: " + c.name()));
    }

    private void printMsg(String msg) {
        System.out.println(LocalDateTime.now() + ": " + msg);
    }
}
