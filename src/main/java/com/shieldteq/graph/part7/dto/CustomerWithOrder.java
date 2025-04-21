package com.shieldteq.graph.part7.dto;

import java.util.List;

public record CustomerWithOrder(
        int id,
        String name,
        Integer age,
        String city,
        List<CustomerOrder> orders
) {
}
