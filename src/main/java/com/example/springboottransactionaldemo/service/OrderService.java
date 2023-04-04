package com.example.springboottransactionaldemo.service;

import com.example.springboottransactionaldemo.dto.OrderRequest;
import com.example.springboottransactionaldemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
