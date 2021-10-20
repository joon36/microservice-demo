package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/helloworld")
    public String helloworld() {
        String world = helloService.getWorld();
        return String.format("Hello, %s", world);
    }
}
