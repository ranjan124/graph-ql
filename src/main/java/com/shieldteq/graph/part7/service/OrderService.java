package com.shieldteq.graph.part7.service;

import com.shieldteq.graph.part7.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {
    private static final Map<String, List<CustomerOrder>> orders = Map.of(
            "John", List.of(new CustomerOrder("1", "First order"), new CustomerOrder("2", "Second order"))
//            "Jane", List.of(new CustomerOrder("3", "Third order"), new CustomerOrder("4", "Fourth order"))
    );

    public Flux<CustomerOrder> getOrders(String customer) {
        return Flux.fromIterable(orders.getOrDefault(customer, List.of()))
                .delayElements(java.time.Duration.ofMillis(ThreadLocalRandom.current().nextInt(1, 1000)))
                .doOnNext(o -> printMsg("Order for: " + customer));
    }

    private void printMsg(String msg) {
        System.out.println(LocalDateTime.now() + ": " + msg);
    }
}

