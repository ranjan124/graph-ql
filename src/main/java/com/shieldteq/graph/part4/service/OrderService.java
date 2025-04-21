package com.shieldteq.graph.part4.service;

import com.shieldteq.graph.part4.dto.Customer;
import com.shieldteq.graph.part4.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private static final Map<String, List<CustomerOrder>> orders = Map.of(
            "John", List.of(new CustomerOrder("1", "First order"), new CustomerOrder("2", "Second order")),
            "Jane", List.of(new CustomerOrder("3", "Third order"), new CustomerOrder("4", "Fourth order"))
    );

//    public Flux<CustomerOrder> getOrders(String customer) {
//        return Flux.fromIterable(orders.getOrDefault(customer, List.of()));
//    }
//
//    public Flux<List<CustomerOrder>> getOrders(List<String> customers) {
//        return Flux.fromIterable(customers)
//                .flatMap(n -> getOrderList(n).defaultIfEmpty(List.of()));
//    }

//    private Mono<List<CustomerOrder>> getOrderList(String name) {
//        return Mono.justOrEmpty(orders.get(name));
//    }

    public Mono<Map<Customer, List<CustomerOrder>>> getOrders(List<Customer> customers) {
        return Flux.fromIterable(customers)
                .map(c -> Tuples.of(c, orders.getOrDefault(c.name(), List.of())))
                .collectMap(Tuple2::getT1, Tuple2::getT2);
    }

}

