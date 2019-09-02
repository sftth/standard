package com.summit.springboot.standard.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {
    @GetMapping("cors")
    public String corsMethod() {
        return "Cors Ok";
    }
}
