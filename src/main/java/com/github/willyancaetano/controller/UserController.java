package com.github.willyancaetano.controller;

import com.github.willyancaetano.dto.UserDto;
import com.github.willyancaetano.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDto user) {
        service.addUser(user);
        return ResponseEntity.created(URI.create("/v1/users/1")).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") String id) {
        service.getUser(id);
        return ResponseEntity.ok(new UserDto("user", "1234"));
    }

    @GetMapping
    public ResponseEntity getUsers() {
        service.getUsers();
        return ResponseEntity.ok(List.of(new UserDto("user", "1234")));
    }
}
