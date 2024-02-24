package com.andrelucs.sweb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelucs.sweb.model.Category;
import com.andrelucs.sweb.services.CategoryService;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping
    public ResponseEntity<Iterable<Category>> findAll(){
    	Iterable<Category> categories = this.service.findAll();
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
    	Category u = this.service.findById(id);
    	if (u == null) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(u);
    }
}
