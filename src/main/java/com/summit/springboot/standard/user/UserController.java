package com.summit.springboot.standard.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {

        return user;
    }

    @PostMapping("/users/createxml")
    public User createxml(@RequestBody User user) {

        return user;
    }
}
