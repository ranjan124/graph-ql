package com.shieldteq.graph.part3.service;

import com.shieldteq.graph.part3.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {
    private static final Flux<Customer> customers = Flux.just(
            new Customer(1, "John", 30, "London"),
            new Customer(2, "Jane", 25, "New York"),
            new Customer(3, "Mike", 40, "Paris")
    );

    public Flux<Customer> getCustomers() {
        return customers;
    }

}
