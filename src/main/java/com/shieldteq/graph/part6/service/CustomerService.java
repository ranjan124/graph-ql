package com.shieldteq.graph.part6.service;

import com.shieldteq.graph.part6.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {
    private static final Flux<Customer> customers = Flux.just(
            new Customer(1, "John", 30),
            new Customer(2, "Jane", 25),
            new Customer(3, "Mike", 40)
    );

    public Flux<Customer> getCustomers() {
        return customers;
    }

}
