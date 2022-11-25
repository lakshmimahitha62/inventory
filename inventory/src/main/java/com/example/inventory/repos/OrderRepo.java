package com.example.inventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders,Integer > {

}
