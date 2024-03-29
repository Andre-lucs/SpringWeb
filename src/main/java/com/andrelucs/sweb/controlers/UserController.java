package com.andrelucs.sweb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelucs.sweb.model.User;
import com.andrelucs.sweb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping
    public ResponseEntity<Iterable<User>> findAll(){
    	Iterable<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
    	User u = userService.findById(id);
    	if (u == null) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(u);
    }
    
}	
