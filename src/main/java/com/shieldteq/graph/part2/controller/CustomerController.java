package com.shieldteq.graph.part2.controller;

import com.shieldteq.graph.part2.dto.AgeRangeFilter;
import com.shieldteq.graph.part2.dto.Customer;
import com.shieldteq.graph.part2.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.getCustomers();
    }

    @QueryMapping
    public Flux<Customer> customerNameContains(@Argument String name) {
        return customerService.getCustomersByName(name);
    }

    @QueryMapping
    public Mono<Customer> customerById(@Argument int id) {
        return customerService.getCustomer(id);
    }

    @QueryMapping
    public Flux<Customer> customerInAge(@Argument AgeRangeFilter filter) {
        return customerService.getCustomersInRange(filter);
    }
}
