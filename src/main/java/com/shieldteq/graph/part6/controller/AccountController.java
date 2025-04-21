package com.shieldteq.graph.part6.controller;

import com.shieldteq.graph.part6.dto.Account;
import com.shieldteq.graph.part6.dto.AccountType;
import com.shieldteq.graph.part6.dto.Customer;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AccountController {
    @SchemaMapping(typeName = "Customer", field = "account")
    public Mono<Account> account(Customer customer, DataFetchingFieldSelectionSet selectionSet) {
        System.out.println("account: " + selectionSet.getFields());
        return Mono.just(new Account(customer.name() + "account1", 200, AccountType.CURRENT));
    }
}
