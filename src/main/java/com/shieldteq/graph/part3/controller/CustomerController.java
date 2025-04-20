package com.shieldteq.graph.part3.controller;

import com.shieldteq.graph.part3.dto.Customer;
import com.shieldteq.graph.part3.dto.CustomerOrder;
import com.shieldteq.graph.part3.service.CustomerService;
import com.shieldteq.graph.part3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.getCustomers();
    }


    @SchemaMapping(typeName = "Customer", field = "orders")
    public Flux<CustomerOrder> orders(Customer customer, @Argument Integer limit) {
        return orderService.getOrders(customer.name(), limit);
    }
}
