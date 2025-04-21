package com.shieldteq.graph.part7.service;

import com.shieldteq.graph.part7.dto.CustomerWithOrder;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class CustomerDataFetcher {
    private final CustomerService customerService;
    private final OrderService orderService;

    public Flux<CustomerWithOrder> customersWithOrders(DataFetchingFieldSelectionSet selectionSet) {
        boolean hasOrders = selectionSet.contains("orders");
        return customerService.getCustomers()
                .map(c -> new CustomerWithOrder(c.id(), c.name(), c.age(), c.city(), List.of()))
                .transform(updateCustomerOrder(hasOrders));

    }

    private UnaryOperator<Flux<CustomerWithOrder>> updateCustomerOrder(boolean hasOrders) {
        return hasOrders ? f -> f.flatMapSequential(this::fetchOrders) : f -> f;
    }

    private Mono<CustomerWithOrder> fetchOrders(CustomerWithOrder c) {
        return orderService.getOrders(c.name())
                .collectList()
                .map(l -> new CustomerWithOrder(c.id(), c.name(), c.age(), c.city(), l));
    }
}
