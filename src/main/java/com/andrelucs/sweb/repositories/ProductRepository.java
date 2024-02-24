package com.andrelucs.sweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andrelucs.sweb.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
