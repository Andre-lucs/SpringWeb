package com.andrelucs.sweb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelucs.sweb.model.Order;
import com.andrelucs.sweb.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping
    public ResponseEntity<Iterable<Order>> findAll(){
    	Iterable<Order> Orders = orderService.findAll();
        return ResponseEntity.ok(Orders);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
    	Order u = orderService.findById(id);
    	if (u == null) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(u);
    }
}
