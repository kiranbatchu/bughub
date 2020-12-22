package com.tb.bughub.order.demo.repository;


import com.tb.bughub.order.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
@Repository
public interface OrderRepository
        extends JpaRepository<Order, Long> {
 
}
