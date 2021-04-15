package com.springboot.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return service.userDetails;
    }

    @GetMapping("/users/{id}")
    public User retriveOne(@PathVariable Integer id)  {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id: " + id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteOne(id);
    }

    @DeleteMapping("/users")
    public void deleteAll() {
        service.deleteAll();
    }


}
