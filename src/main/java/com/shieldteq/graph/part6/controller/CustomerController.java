package com.shieldteq.graph.part6.controller;

import com.shieldteq.graph.part6.dto.Customer;
import com.shieldteq.graph.part6.service.CustomerService;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @QueryMapping
    public Flux<Customer> customers(DataFetchingFieldSelectionSet selectionSet) {
        System.out.println("customer: " + selectionSet.getFields());
        return customerService.getCustomers();
    }

}
