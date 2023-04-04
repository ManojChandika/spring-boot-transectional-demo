package com.example.springboottransactionaldemo.service.serviceImp;

import com.example.springboottransactionaldemo.dto.OrderRequest;
import com.example.springboottransactionaldemo.dto.OrderResponse;
import com.example.springboottransactionaldemo.entity.Order;
import com.example.springboottransactionaldemo.entity.Payment;
import com.example.springboottransactionaldemo.exception.PaymentException;
import com.example.springboottransactionaldemo.repo.OrderRepo;
import com.example.springboottransactionaldemo.repo.PaymentRepo;
import com.example.springboottransactionaldemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
@Service
@Transactional
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private PaymentRepo paymentRepo;
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepo.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support !");
        }

        payment.setOrderId(order.getId());
        paymentRepo.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMassage("SUCCESS");

        return orderResponse;
    }
}
