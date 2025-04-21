package com.shieldteq.graph.part5.controller;

import com.shieldteq.graph.part5.dto.Account;
import com.shieldteq.graph.part5.dto.AccountType;
import com.shieldteq.graph.part5.dto.Customer;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AccountController {
    @SchemaMapping(typeName = "Customer", field = "account")
    public Mono<Account> account(Customer customer) {
        return Mono.just(new Account(customer.name() + "account1", 200, AccountType.CURRENT));
    }
}
