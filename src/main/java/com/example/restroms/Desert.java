package com.example.restroms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Desert {
    @GetMapping("/mydesert")
        public String getData(){
        return "Please order your fav desert!!";
    }
}
