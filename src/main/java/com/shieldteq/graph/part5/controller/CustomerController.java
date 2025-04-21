package com.shieldteq.graph.part5.controller;

import com.shieldteq.graph.part5.dto.Customer;
import com.shieldteq.graph.part5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.getCustomers();
    }

}
