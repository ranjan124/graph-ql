package com.shieldteq.graph.part6.controller;

import com.shieldteq.graph.part6.dto.Address;
import com.shieldteq.graph.part6.dto.Customer;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AddressController {
    @SchemaMapping(typeName = "Customer", field = "address")
    public Mono<Address> address(Customer customer, DataFetchingFieldSelectionSet selectionSet) {
        System.out.println("address: " + selectionSet.getFields());
        return Mono.just(new Address(customer.name() + " street", customer.name() + " city"));
    }
}
