package com.example.springboottransactionaldemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private String orderTrackingNumber;
    private String status;
    private String massage;
}
