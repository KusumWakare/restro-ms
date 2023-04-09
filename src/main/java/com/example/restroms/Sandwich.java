package com.example.restroms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sandwich {
    @GetMapping("/mysandwich")
    public String getData(){
        return "Please order your fav sandwich!!";
    }
}