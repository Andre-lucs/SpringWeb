package com.andrelucs.sweb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelucs.sweb.model.Product;
import com.andrelucs.sweb.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
    public ResponseEntity<Iterable<Product>> findAll(){
    	Iterable<Product> Products = productService.findAll();
        return ResponseEntity.ok(Products);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
    	Product u = productService.findById(id);
    	if (u == null) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(u);
    }
}
