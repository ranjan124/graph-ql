package com.shieldteq.graph.part4.controller;

import com.shieldteq.graph.part4.dto.Customer;
import com.shieldteq.graph.part4.dto.CustomerOrder;
import com.shieldteq.graph.part4.service.CustomerService;
import com.shieldteq.graph.part4.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.getCustomers();
    }

//
//    @BatchMapping(typeName = "Customer", field = "orders")
//    public Flux<List<CustomerOrder>> orders(List<Customer> customers) {
//        return orderService.getOrders(customers.stream().map(Customer::name).toList());
//    }

    @BatchMapping(typeName = "Customer", field = "orders")
    public Mono<Map<Customer, List<CustomerOrder>>> orders(List<Customer> customers) {
        return orderService.getOrders(customers);
    }
}
