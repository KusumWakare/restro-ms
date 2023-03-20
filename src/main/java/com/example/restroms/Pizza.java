package com.example.restroms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pizza {
    @GetMapping("/mypizza")
    public String getData(){
        return "Please order your pizza!!!";
    }
}