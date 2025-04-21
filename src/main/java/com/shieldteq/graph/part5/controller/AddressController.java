package com.shieldteq.graph.part5.controller;

import com.shieldteq.graph.part5.dto.Address;
import com.shieldteq.graph.part5.dto.Customer;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AddressController {
    @SchemaMapping(typeName = "Customer", field = "address")
    public Mono<Address> address(Customer customer) {
        return Mono.just(new Address(customer.name() + " street", customer.name() + " city"));
    }
}
