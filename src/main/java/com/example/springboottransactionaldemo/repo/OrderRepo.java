package com.example.springboottransactionaldemo.repo;

import com.example.springboottransactionaldemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {

}
