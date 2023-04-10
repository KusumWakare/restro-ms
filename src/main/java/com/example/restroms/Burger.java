package com.example.restroms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Burger{
    @GetMapping("/myburger")
    public String getData(){
        return "Please order your fav Burger!!";
    }
}