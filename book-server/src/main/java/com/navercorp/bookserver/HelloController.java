package com.navercorp.bookserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    String home(){
        return "helloo!!!!!";
    }
}
