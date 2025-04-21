package com.shieldteq.graph.part7.controller;

import com.shieldteq.graph.part7.dto.CustomerWithOrder;
import com.shieldteq.graph.part7.service.CustomerDataFetcher;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDataFetcher dataFetcher;

    @QueryMapping
    public Flux<CustomerWithOrder> customers(DataFetchingFieldSelectionSet selectionSet) {
        return dataFetcher.customersWithOrders(selectionSet);
    }

}
