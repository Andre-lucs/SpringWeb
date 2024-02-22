package com.andrelucs.sweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andrelucs.sweb.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
