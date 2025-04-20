package com.shieldteq.graph.part2.service;

import com.shieldteq.graph.part2.dto.AgeRangeFilter;
import com.shieldteq.graph.part2.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Customer> getCustomer(int id) {
        return customers.filter(c -> c.id() == id).next();
    }

    public Flux<Customer> getCustomersByName(String name) {
        return customers.filter(c -> c.name().contains(name));
    }

    public Flux<Customer> getCustomersInRange(AgeRangeFilter filter) {
        return customers.filter(c -> c.age() >= filter.min() && c.age() <= filter.max());
    }
}
