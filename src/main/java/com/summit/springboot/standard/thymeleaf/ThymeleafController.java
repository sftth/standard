package com.summit.springboot.standard.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name","jacob");
        return "thymeleaf";
    }

}
