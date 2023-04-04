package com.example.springboottransactionaldemo.dto;

import com.example.springboottransactionaldemo.entity.Order;
import com.example.springboottransactionaldemo.entity.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;
}
