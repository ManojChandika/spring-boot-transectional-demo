package com.example.springboottransactionaldemo.repo;

import com.example.springboottransactionaldemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
