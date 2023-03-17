package com.example.restroms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coffee {
    @GetMapping("/mycoffee")
    public String getData(){
        return "Please order your coffee!!!";
    }
}
